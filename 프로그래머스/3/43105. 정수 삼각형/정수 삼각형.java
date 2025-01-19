import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] result = new int[triangle.length][triangle.length];
        
        result[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
            result[i][0] = result[i-1][0] + triangle[i][0];
            for(int j = 1; j < triangle[i].length; j++) {
                result[i][j] = Math.max(result[i-1][j-1], result[i-1][j]) + triangle[i][j];
            }
            result[i][triangle[i].length - 1] = result[i-1][triangle[i-1].length - 1] + triangle[i][triangle[i].length - 1];
        }
        int answer = 0;
        
        for(int i = 0; i < result[result.length - 1].length; i++) {
            answer = Math.max(result[result.length - 1][i], answer);
        }
        
        return answer;
    }
}