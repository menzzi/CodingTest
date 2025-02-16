import java.util.*;
import java.io.*;

class Main {
    static int N, sharkSize = 2, time = 0;
    static int[][] map;

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;
        int[] shark = new int[2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9) {
                    shark[0] = i;
                    shark[1] = j;
                }
            }
        }

        BFS(shark[0], shark[1]);
        System.out.println(time);
    }

    private static void BFS(int x, int y) {
        int eating = 0;

        while(true) {
            Queue<int[]> queue = new LinkedList<>();
            List<int[]> fishes = new ArrayList<>();
            boolean[][] visited = new boolean[N][N];

            visited[x][y] = true;
            queue.add(new int[] {x,y,0});

            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if(map[nx][ny] <= sharkSize) {
                            if(map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                                fishes.add(new int[] {nx, ny, poll[2] + 1});
                            }
                            queue.add(new int[] {nx, ny, poll[2] + 1});
                        }
                    }
                }
            }

            if(fishes.isEmpty()) {
                break;
            }

            if(fishes.size() > 1) {
                fishes.sort((a,b) -> {
                   if(a[2] == b[2]) {
                       if(a[0] == b[0]) return a[1] - b[1];
                       else return a[0] - b[0];
                   } else return a[2] - b[2];
                });
            }

            int[] fish = fishes.get(0);
            time += fish[2];
            eating++;

            map[x][y] = 0;
            x = fish[0];
            y = fish[1];
            map[x][y] = 9;

            if(eating == sharkSize) {
                sharkSize++;
                eating = 0;
            }
        }
    }
}