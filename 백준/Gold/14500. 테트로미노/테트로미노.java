import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int max = 0;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                DFS(1, i, j, map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private static void DFS(int depth, int cx, int cy, int sum) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

            if(depth == 2) {
                visited[nx][ny] = true;
                DFS(depth + 1, cx, cy, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
            visited[nx][ny] = true;
            DFS(depth + 1, nx, ny, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}