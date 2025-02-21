import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static List<int[]> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[N][M];

        for(int i = 1; i < N - 1; i++) {
            for(int j = 1; j < M - 1; j++) {
                if(map[i][j] == '*') {
                    int S = 0;
                    int size = 1;
                    while(true) {
                        if(i - size < 0 || i + size >= N || j - size < 0 || j + size >= M) break;

                        if(map[i - size][j] == '*' && map[i + size][j] == '*' && map[i][j - size] == '*' && map[i][j + size] == '*') {
                            S = size;
                            size++;
                        } else break;
                    }

                    if(S > 0) {
                        visited[i][j] = true;
                        answer.add(new int[] {i + 1, j + 1, S});
                        for(int k = 1; k <= S; k++) {
                            visited[i - k][j] = true;
                            visited[i + k][j] = true;
                            visited[i][j - k] = true;
                            visited[i][j + k] = true;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] == '*') {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer.size());
        for(int[] ans : answer) {
            System.out.printf("%d %d %d\n", ans[0], ans[1], ans[2]);
        }
    }
}