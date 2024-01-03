import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        char[] array = number.toCharArray();
        int len = number.length() - k;
        int idx = 0;
        for(int i =0;i<len;i++){
            char max = '0';
            for(int j=idx;j<=k+i;j++){
                if(max<array[j]){
                    max = array[j];
                    idx = j+1;
                }
            }
            sb.append(max);
        }
        answer = sb.toString();    
        
        return answer;
    }
}