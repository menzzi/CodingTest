import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[] open;
    static int min = Integer.MAX_VALUE;
    static int N, M;

    static List<int[]> person = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    person.add(new int[]{i, j});
                } else if(map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        open = new boolean[chicken.size()];

        DFS(0, 0);
        System.out.println(min);
    }

    private static void DFS(int start, int cnt) {
        if(cnt == M) {
            int res = 0;

            for(int i = 0; i < person.size(); i++) {
                int tmp = Integer.MAX_VALUE;

                for(int j = 0; j < chicken.size(); j++) {
                    if(open[j]) {
                        int dis = Math.abs(person.get(i)[0] - chicken.get(j)[0]) + Math.abs(person.get(i)[1] - chicken.get(j)[1]);
                        tmp = Math.min(tmp, dis);
                    }
                }
                res += tmp;
            }

            min = Math.min(min, res);
            return;
        }

        for(int i = start; i < chicken.size(); i++) {
            open[i] = true;
            DFS(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}