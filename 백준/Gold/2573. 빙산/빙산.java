import java.util.*;
import java.io.*;

class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while(true) {
            int countB = countIceBlock();
            if(countB >= 2) break;

            if(countB == 0) {
                cnt = 0;
                break;
            }
            cnt++;
            melt();

        }
        System.out.println(cnt);
    }

    private static void melt() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(!visited[nx][ny] && map[nx][ny] <= 0) {
                    map[x][y]--;
                }
            }
        }
    }

    private static int countIceBlock() {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];

                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                            if(!visited[nx][ny] && map[nx][ny] > 0) {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}