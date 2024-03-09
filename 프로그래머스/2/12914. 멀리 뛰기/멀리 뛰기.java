class Solution {
    public long solution(int n) {
        long[] d = new long[2001];
        if(n==1)return 1;
        else if (n==2) return 2;
        
        d[1] = 1L;
        d[2] = 2L;
        
        for(int i=3;i<=n;i++){
            d[i] = (d[i-2]+d[i-1])%1234567;
        }
        return d[n];
    }
}