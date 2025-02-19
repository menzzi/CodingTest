import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1) {
            dp[1] = arr[1];
        } else if(N == 2) {
            dp[2] = arr[1] + arr[2];
        } else {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
            for(int i = 4; i < N + 1; i++) {
                dp[i] = Math.max(arr[i] + dp[i - 2], arr[i] + dp[i - 3] + arr[i - 1]);
            }
        }

        System.out.println(dp[N]);
    }
}