import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int maxNumIndex = 0;
        int lastIndex = k;
        
        while(answer.length() < number.length()-k){
            char max = Character.MIN_VALUE;
            int maxIndex = 0;
            for(int i = maxNumIndex; i <= lastIndex; i++){
                char num = number.charAt(i);
                if(max < num){
                    max = num;
                    maxIndex = i;
                }
            }
            if(maxIndex == lastIndex) {
                answer.append(number.substring(lastIndex));
                return answer.toString();
            }
            answer.append(number.charAt(maxIndex));
            maxNumIndex = maxIndex + 1;
            lastIndex++;
        }
    
        return answer.toString();
    }
}