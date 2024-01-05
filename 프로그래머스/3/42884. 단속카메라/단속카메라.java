import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(int[] r1,int[] r2)->r1[1]-r2[1]);
        
        int current = -30001;
        for(int i=0;i<routes.length;i++){
            if(current < routes[i][0]){
                answer++;
                current = routes[i][1];
            }
        }
        
        return answer;
    }
}