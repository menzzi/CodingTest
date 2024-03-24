import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        for(int i=0;i<s.length();i++){
            int len1 = palindrome(s,i,i);
            int len2 = palindrome(s,i,i+1);
            int len = Math.max(len1,len2);
            answer = Math.max(answer,len);
        }
        return answer;
    }
    public int palindrome(String s,int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
        
}