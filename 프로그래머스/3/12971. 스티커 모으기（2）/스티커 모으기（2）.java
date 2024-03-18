import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length==1)return sticker[0];
        else if(sticker.length==2)return Math.max(sticker[0],sticker[1]);
        
        int[] left = new int[sticker.length];
        int[] right = new int[sticker.length];
        
        left[0] = sticker[0];
        left[1] = Math.max(sticker[0],sticker[1]);
        
        right[0] = 0;
        right[1] = sticker[1];
        
        for(int i=2;i<sticker.length;i++){
            right[i] = Math.max(right[i-1],right[i-2]+sticker[i]);
            answer = Math.max(right[i],answer);
            
            if(i==sticker.length-1){
                break;
            }
            left[i] = Math.max(left[i-1],left[i-2]+sticker[i]);
            answer = Math.max(left[i],answer);
            
        }
        
        return answer;
    }
}