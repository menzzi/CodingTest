import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] map;
    static int[][] count;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        count = new int[N][M];
        visited = new boolean[N][M];

        int[] target = new int[2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }

        visited[target[0]][target[1]] = true;
        BFS(target[0], target[1]);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0 || map[i][j] == 2) {
                    System.out.print(0 + " ");
                } else if(!visited[i][j] && map[i][j] == 1) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(count[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                    count[nx][ny] = count[cx][cy] + 1;
                }
            }
        }
    }
}