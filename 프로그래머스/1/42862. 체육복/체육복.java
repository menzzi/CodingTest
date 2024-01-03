class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] count = new int[n+1];
        for(int i=1;i<=n;i++){
            count[i] = 1;
        }
        for(int i=0;i<lost.length;i++){
            count[lost[i]] -= 1;
        }
        for(int i=0;i<reserve.length;i++){
            count[reserve[i]] += 1;
        }
        
        if(count[1]==0){
            if(count[2]==2){
                count[2]=1;
                answer++;
            }
        }else if(count[1]==1||count[1]==2)answer++;
            
        for(int i=2;i<n;i++){
            if(count[i]==1||count[i]==2)answer++;
            else if(count[i]==0){
                if(count[i-1]==2){
                    count[i-1]=1;
                    answer++;
                }else if(count[i+1]==2){
                    count[i+1]=1;
                    answer++;
                }
            }
        }
  
        
        if(count[n]==0){
            if(count[n-1]==2){
                count[n-1]=1;
                answer++;
            }
        }else if(count[n]==1||count[n]==2)answer++;
        
        return answer;
    }
}