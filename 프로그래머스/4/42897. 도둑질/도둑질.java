import java.lang.Math;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        if(money.length == 3){
            for(int i=0;i<money.length;i++){
                if(answer<money[i])answer = money[i];
            }
            return answer;
        }
        
        int[] left = new int[money.length];
        left[0] = money[0];
        left[1] = Math.max(money[0],money[1]);
        
        int[] right = new int[money.length];
        right[0] = 0;
        right[1] = money[1];
        
        for(int i=2;i<money.length;i++){
            right[i] = Math.max(right[i-1],right[i-2]+money[i]);
            answer = Math.max(answer,right[i]);
            
            if(i == money.length-1)break;
            left[i] = Math.max(left[i-1],left[i-2]+money[i]);
            answer = Math.max(answer,left[i]);
        }
        return answer;
    }
}