import java.util.*;
import java.io.*;

class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][] visited;
    static int R, C;
    static int count = 0;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        Set<Character> set = new HashSet<>();
        set.add(map[0][0]);
        DFS(0, 0, set, 1);

        System.out.println(count);
    }

    private static void DFS(int r, int c, Set<Character> set, int cnt) {
        count = Math.max(count, cnt);

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if(!set.contains(map[nr][nc])) {
                    set.add(map[nr][nc]);
                    DFS(nr, nc, set, cnt + 1);
                    set.remove(map[nr][nc]);
                }
            }
        }
    }
}