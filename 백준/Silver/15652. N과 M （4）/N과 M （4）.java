import java.util.*;
import java.io.*;

class Main {
    static int[] a;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        a = new int[N + 1];

        makeStr(1,0);
        System.out.println(sb);
    }

    private static void makeStr(int idx, int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i <= N; i++) {
            a[depth] = i;
            makeStr(i, depth+ 1);
        }
    }
}