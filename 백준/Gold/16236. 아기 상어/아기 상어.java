import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static int N, time = 0;
    static int sharkSize = 2;

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int[] shark = new int[2];
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
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
            queue.add(new int[] {x, y, 0});

            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                int moving = poll[2];

                for(int i = 0; i < 4; i++) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;

                        if(map[nx][ny] <= sharkSize) {
                            if(map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                                fishes.add(new int[]{nx, ny, moving + 1});
                            }
                            queue.add(new int[]{nx, ny, moving + 1});
                        }
                    }
                }
            }

            if(fishes.isEmpty()) {
                break;
            } else {
                if(fishes.size() > 1) {
                    sorting(fishes);
                }

                int[] oneFish = fishes.get(0);
                time += oneFish[2];
                eating++;

                map[x][y] = 0;
                x = oneFish[0];
                y = oneFish[1];
                map[x][y] = 9;

                if(sharkSize == eating) {
                    sharkSize++;
                    eating = 0;
                }
            }
        }
    }

    private static void sorting(List<int[]> list) {
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] == o2[2]) {
                    if(o1[0] == o2[0]) {
                        return o1[1] - o2[1];

                    }else {
                        return o1[0] - o2[0];
                    }
                } else{
                    return o1[2] - o2[2];
                }
            }
        });
    }
}