import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int[][] triangle = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];


        for(int i = 1; i < N; i++){
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[N - 1][i]);
        }
        System.out.println(answer);
    }
}