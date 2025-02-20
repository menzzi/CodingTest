import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int[][] dp = new int[board.length + 1][board[0].length + 1];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dp[i + 1][j + 1] = board[i][j];
            }
        }
        
        int max = 0;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(dp[i][j] == 1) {
                    int up = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    int leftUp = dp[i - 1][j - 1];
                    int min = Math.min(up, Math.min(left, leftUp));
                    dp[i][j] = min + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        int answer = max * max;
        return answer;
    }
}