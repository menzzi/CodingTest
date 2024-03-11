import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            if(check(s))answer++;
            String ss = s.substring(0,1);
            s = s.substring(1) + ss;
        }
        return answer;
    }
    public boolean check(String s){
        Stack<Character> st = new Stack<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        if(s.charAt(0)==']'||s.charAt(0)=='}'||s.charAt(0)==')')return false;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='(')st.push(s.charAt(i));
           
            else if(!st.isEmpty()&&st.peek()=='[' && s.charAt(i)==']')st.pop();
            else if(!st.isEmpty()&&st.peek()=='{' && s.charAt(i)=='}')st.pop();
            else if(!st.isEmpty()&&st.peek()=='(' && s.charAt(i)==')')st.pop();
            
        }
        if(st.isEmpty())return true;
        else return false;
    }
}