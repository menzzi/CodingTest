import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> a = new ArrayList<>();
        
        for(int i=0;i<progresses.length;i++){
            int day = 0;
            while(progresses[i]+speeds[i]*day<100){
                day++;
            }
            q.offer(day);
        }
        
        while(!q.isEmpty()){
            int num = q.poll();
            int cnt = 1;
            while(!q.isEmpty() && q.peek()<=num){
                q.poll();
                cnt++;
            }
            a.add(cnt);
        }
       
        
        return a.stream().mapToInt(Integer::intValue).toArray(); 
    }
}