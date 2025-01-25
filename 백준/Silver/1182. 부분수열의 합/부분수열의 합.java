import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        BFS(N, S, 0, 0);
        if(S == 0) {
            answer--;
        }
        System.out.println(answer);
    }

    private static void BFS(int N, int S, int depth, int sum) {
        if(depth == N) {
            if(S == sum) {
                answer++;
            }
            return;
        }
        BFS(N, S, depth + 1, sum);
        BFS(N, S, depth + 1, sum + arr[depth]);
    }
}