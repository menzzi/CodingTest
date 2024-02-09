import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        if(isCheck(p)) return p;
        else answer = split(p);
        return answer;
    }
    
    public boolean isCheck(String str){
        int open = 0;
        for(int i=0;i<str.length();i++){
            if(i==0 && str.charAt(i) == ')') return false;
            if(str.charAt(i) == '(')open++;
            else open--;
            
            if(open<0) return false;
        }
        if(open==0)return true;
        else return false;
    }
    public String recur(String str){
        StringBuilder s = new StringBuilder();
        for(int i=1;i<str.length()-1;i++){
            if(str.charAt(i)=='(')s.append(")");
            else s.append("(");
        }
        return s.toString();
    }
    public String split(String str){
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        if(str.length()==0)return "";
        
        int open=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(')open++;
            else open--;
            
            if(open==0){
                u.append(str.substring(0,i+1));
                v.append(str.substring(i+1,str.length()));
                
                if(isCheck(u.toString())){
                    u.append(split(v.toString()));
                }else{
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    sb.append(split(v.toString()));
                    sb.append(")");
                    sb.append(recur(u.toString()));
                    return sb.toString();
                }
                break;
            }
        }
        return u.toString();
    }
}