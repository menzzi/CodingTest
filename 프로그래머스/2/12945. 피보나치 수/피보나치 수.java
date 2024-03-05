class Solution {
    public long solution(int n) {
        long answer = 0;
        int[] F = new int[n+1];
        if(n==0) return 0;
        else if(n==1||n==2) return 1;
        
        F[0]=0;
        F[1]=1;
        
        for(int i=2;i<=n;i++){
            F[i] = F[i-1]+F[i-2];
            F[i] %= 1234567;
        }
        answer = F[n];
        return answer;
    }
   
}