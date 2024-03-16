class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 1;
        for(int i=0;i<stations.length;i++){
            int num = stations[i];
            int len = num-w-idx;
            if(len!=0){
                answer+=len/(2*w+1);
                if(len%(2*w+1)>0)answer+=1;
            }
            idx = num + w +1;
        }
        int len = n-idx+1;
        if(len!=0){
            answer+=len/(2*w+1);
            if(len%(2*w+1)>0)answer+=1;
        }


        return answer;
    }
}