import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int remove = 0;
        
        while(s.length()>0){
            count++;
            remove+=s.length();
            int len = s.replaceAll("0","").length();
            remove-=len;
            s = Integer.toBinaryString(len);
            if(s.length()==1)break;
        }
        
        answer[0] = count;
        answer[1] = remove;
        return answer;
    }
}