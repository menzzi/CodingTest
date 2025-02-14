import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static boolean[] broken;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];
        if(N == 100) {
            System.out.println(0);
            return;
        }
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
        }

        min = Math.abs(100 - N);
        DFS(0, 0);
        System.out.println(min);
    }

    private static void DFS(int depth, int bt) {
        for(int i = 0; i < 10; i++) {
            if(!broken[i]) {
                int newBt = bt * 10 + i;
                int count = Math.abs(N - newBt) + String.valueOf(newBt).length();
                min = Math.min(min, count);

                if(depth < 6) {
                    DFS(depth + 1, newBt);
                }
            }
        }
    }
}