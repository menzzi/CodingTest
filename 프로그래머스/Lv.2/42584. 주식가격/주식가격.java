import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        Queue<Integer> q =new LinkedList<>();
        for(int i=0;i<prices.length;i++){
            int cnt = -1;
            for(int j=i;j<prices.length;j++){
                if(prices[i]<=prices[j]){
                    cnt++;
                    if(j == prices.length-1){
                        q.add(cnt);
                        break;
                    }
                }else if(prices[i] > prices[j]){
                    cnt++;
                    q.add(cnt);
                    break;
                }
            }
        }
        answer = new int[prices.length];
        int idx = 0;
        while(!q.isEmpty()){
            answer[idx++] = q.poll();
        }
        return answer;
    }
}