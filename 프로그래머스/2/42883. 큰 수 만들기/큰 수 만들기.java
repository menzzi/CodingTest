import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> st = new Stack<>();
        int num = k;
        for(int i=0;i<number.length();i++){
            char c = number.charAt(i);
            while(!st.isEmpty() && st.peek()<c && k > 0){
                st.pop();
                k-=1;
            }
            
            st.push(c);
        }
        
        for(int i=0;i<number.length()-num;i++){
            answer += st.get(i);
        }
        
        
        return answer;
    }
}