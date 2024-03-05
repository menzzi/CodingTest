import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase(); // 일단 다 소문자로 !!
        StringTokenizer st = new StringTokenizer(s," ",true);
        
        StringBuilder sb = new StringBuilder();
        
        while(st.hasMoreTokens()){
            String word = st.nextToken();
            if(word.length()==0)sb.append(" ");
            else {
                sb.append(word.substring(0,1).toUpperCase());
                sb.append(word.substring(1));
            }
        }
        return sb.toString();
    }
}