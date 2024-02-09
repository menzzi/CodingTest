import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1;i<=s.length()/2;i++){
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0,i);
            int cnt = 1;
            for(int j=i;j<s.length();j+=i){
                int end = Math.min(j+i,s.length());
                String now = s.substring(j,end);
                if(base.equals(now)){
                    cnt++;
                }else{
                    if(cnt>=2)sb.append(cnt);
                    sb.append(base);
                    base = now;
                    cnt=1;
                }
            }
            if(cnt>=2)sb.append(cnt);
            sb.append(base);
            answer = Math.min(answer,sb.toString().length());
        }
        return answer;
    }
}