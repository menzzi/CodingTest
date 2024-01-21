import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        if(money.length == 3){
            for(int i=0;i<money.length;i++){
                answer = Math.max(answer,money[i]);
            }
            return answer;
        }
        
        int[] left = new int[money.length];
        int[] right = new int[money.length];
        
        left[0] = money[0];
        left[1] = Math.max(money[0],money[1]);
            
        right[0] = 0;
        right[1] = money[1];
        
        for(int i=2;i<money.length;i++){
            right[i] = Math.max(right[i-1],money[i]+right[i-2]);
            answer = Math.max(answer, right[i]);
            
            if(i == money.length-1) break;
            left[i] = Math.max(left[i-1],money[i]+left[i-2]);
            answer = Math.max(answer, left[i]);
        }
        
        
        return answer;
    }
}