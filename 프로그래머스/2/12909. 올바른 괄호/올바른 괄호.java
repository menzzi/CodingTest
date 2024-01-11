import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(1);
            }else{
                if(st.isEmpty())return false;
                else st.pop();
            }
        }
        if(st.isEmpty())return true;
        return answer;
    }
}