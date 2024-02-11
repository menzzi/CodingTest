import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        if(w==h) return (long)w*(h-1);
        answer = (long)w*h -(w+h-gcd(w,h));
        return answer;
    }
    
    public int gcd(int w,int h){
        int a = Math.max(w,h);
        int b = Math.min(w,h);
        while(b!=0){
            int c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
}