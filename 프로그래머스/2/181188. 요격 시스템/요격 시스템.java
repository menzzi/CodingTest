import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (a, b) -> (a[1] - b[1]));
        
        int end = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
            if(end <= targets[i][0]) {
                answer++;
                end = targets[i][1];
            }
        }            
            
        return answer;
    }
}