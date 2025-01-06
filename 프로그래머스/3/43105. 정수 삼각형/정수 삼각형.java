import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] sum = new int[triangle.length][triangle.length]; 
        sum[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++) {
            sum[i][0] = triangle[i][0] + sum[i-1][0];
            for(int j = 1; j < triangle[i].length - 1; j++) {
                sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j]) + triangle[i][j];
            }
            sum[i][triangle[i].length - 1] = triangle[i][triangle[i].length - 1] + sum[i-1][triangle[i-1].length - 1];
            
        }
        
        for(int i = 0; i < sum.length - 1; i++){
            answer = Math.max(sum[sum.length - 1][i], answer);
        }
        return answer;
    }
}