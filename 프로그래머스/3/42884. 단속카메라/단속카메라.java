
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes,(int[] r1,int[] r2)->r1[1]-r2[1]);
        int out = routes[0][1];
        
        for(int i=1;i<routes.length;i++){
            if(out >= routes[i][0]) continue;
            out = routes[i][1];
            answer++;
        }
        return answer;
    }
}