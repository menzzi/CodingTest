import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<String> st = new Stack<>();
        String[] str = s.split("");
        for(int i=0;i<str.length;i++){
            if(!st.isEmpty() && st.peek().equals(str[i]))st.pop();
            else st.push(str[i]);
        }
        if(st.isEmpty()) answer = 1;
        return answer;
    }
}