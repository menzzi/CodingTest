import java.util.*;
import java.io.*;

class Main {
    static final int dx[] = {0,0,1,-1};
    static final int dy[] = {1,-1,0,0};

    static int N, M;
    static int result = 0;
    static int[][] map;
    static int[][] testMap;
    static List<int[]> virus = new ArrayList<>();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        testMap = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        makeWall(0);
        System.out.println(result);
    }

    private static void makeWall(int depth) {
        if(depth == 3) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    testMap[i][j] = map[i][j];
                }
            }
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>(virus);

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(testMap[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    testMap[nx][ny] = 2;
                }
            }
        }
        findSafeZone();
    }

    private static void findSafeZone() {
        int safeZone = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(testMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        result = Math.max(result, safeZone);
    }
}