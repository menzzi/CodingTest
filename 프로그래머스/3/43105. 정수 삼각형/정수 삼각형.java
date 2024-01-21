import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] map = new int[triangle.length][triangle.length];
        map[0][0] = triangle[0][0];
        
        for(int i=1;i<triangle.length;i++){
            map[i][0] = map[i-1][0] + triangle[i][0];
            for(int j=1;j<triangle[i].length-1;j++){
                map[i][j] = Math.max(map[i-1][j-1],map[i-1][j]) + triangle[i][j];
            }
            map[i][triangle[i].length-1] = map[i-1][triangle[i-1].length-1] + triangle[i][triangle[i].length-1];

        }
        
        for(int i=0;i<triangle.length;i++){
            answer = Math.max(answer,map[triangle.length-1][i]);
        }
        return answer;
    }
}