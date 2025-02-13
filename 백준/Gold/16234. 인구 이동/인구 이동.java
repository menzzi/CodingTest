import java.util.*;
import java.io.*;

class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static boolean isMove;
    static ArrayList<int[]> list = new ArrayList<>();
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while(true) {
            isMove = false;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        BFS(i, j);
                    }
                }
            }
            if(!isMove) break;
            else count++;
        }
        
        System.out.println(count);
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        list.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                if(!visited[nx][ny] && diff <= R && diff >= L) {
                    isMove = true;
                    visited[nx][ny] = true;
                    list.add(new int[]{nx, ny});
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            sum += map[list.get(i)[0]][list.get(i)[1]];
        }

        for(int i = 0; i < list.size(); i++) {
            map[list.get(i)[0]][list.get(i)[1]] = sum / list.size();
        }
        list.removeAll(list);
    }
}