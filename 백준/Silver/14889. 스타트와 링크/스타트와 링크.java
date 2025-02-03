import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[] visited;
    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0,0);
        System.out.println(min);
    }

    private static void DFS(int depth, int idx) {
        if(depth == N / 2) {
            diff();
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {
        int team_start = 0;
        int team_link = 0;

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                } else if(!visited[i] && !visited[j]) {
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }

        int result = Math.abs(team_start - team_link);

        if(result == 0) {
            System.out.println(result);
            System.exit(0);
        }

        min = Math.min(min, result);
    }
}