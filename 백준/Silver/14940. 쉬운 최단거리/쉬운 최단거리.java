import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static int[][] count;
    static boolean[][] visited;

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        count = new int[n][m];
        visited = new boolean[n][m];
        int x = 0, y = 0;

        for(int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        visited[x][y] = true;
        BFS(x, y);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m ; j++) {
                if(map[i][j] == 0 || map[i][j] == 2) {
                    System.out.print("0 ");
                } else if(!visited[i][j] && map[i][j] == 1) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(count[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int px = poll[0];
            int py = poll[1];

            for(int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;

                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                    count[nx][ny] = count[px][py] + 1;
                }
            }
        }
    }
}