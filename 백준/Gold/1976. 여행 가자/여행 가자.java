import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp == 1) {
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = find(Integer.parseInt(st.nextToken()));
        for(int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (start != find(now)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static int find(int x) {
        if(x == parents[x]) {
            return x;
        } else return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(parentX != parentY) {
            if(parentX < parentY) {
                parents[parentY] = parentX;
            } else {
                parents[parentX] = parentY;
            }
        }
    }

}