class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] st = new int[n+1];
        for(int i=0;i<lost.length;i++){
            st[lost[i]] -= 1;
        }
        for(int i=0;i<reserve.length;i++){
            st[reserve[i]] +=1;
        }
        for(int i=1;i<n;i++){
            if(st[i] == -1){
                if(st[i-1] == 1 && i-1 != 0){
                    st[i-1] -=1;
                }else if(st[i+1] == 1 ){
                    st[i+1] -=1;
                }else{
                    answer -=1;
                }
            }
        }
        if(st[n]==-1){
            if(st[n-1]!=1) answer-=1;
        }
        return answer;
    }
}