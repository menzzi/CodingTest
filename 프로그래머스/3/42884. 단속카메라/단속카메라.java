import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (int[] c1,int[] c2) -> (c1[1] - c2[1]));
        
        int current = routes[0][1];
        for(int i = 1; i < routes.length; i++){
            if(current < routes[i][0]){
                current = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}