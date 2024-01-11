import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> aq = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            int day = 0;
            while(progresses[i]+speeds[i]*day <100){
                day+=1;
            }
            q.add(day);
        }
        
        while(!q.isEmpty()){
            int cnt = 1;
            int p = q.poll();
            while(!q.isEmpty() && q.peek()<=p){
                q.poll();
                cnt+=1;
            }
            aq.add(cnt);
        }
        int[] answer = new int[aq.size()];
        int idx = 0;
        while(!aq.isEmpty()){
            answer[idx] = aq.poll();
            idx+=1;
        }
        return answer;
    }
}