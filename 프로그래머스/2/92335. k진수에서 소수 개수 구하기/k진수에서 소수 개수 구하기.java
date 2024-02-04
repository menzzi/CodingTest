import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int j=0;
        String s = to_Knum(n,k);
        for(int i=0;i<s.length();i=j){
            for(j=i+1;j<s.length() && s.charAt(j)!='0';j++);
            if(isPrime(Long.parseLong(s.substring(i,j)))) 
                answer++;
        }
        return answer;
    }
    public String to_Knum(int n,int k){
        String res = "";
        while(n>0){
            res = n%k +res;
            n/=k;
        }
        return res;
    }
    public boolean isPrime(long num){
        if(num<=1)return false;
        else if(num==2) return true;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)return false;
        }
        return true;
    }
}