import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long total = 0;
        long sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=0;i<queue1.length;i++){
            total += (long)queue1[i]+queue2[i];
            sum += (long)queue1[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        if(total%2!=0)return -1;
        total/=2;
      
        while(answer<queue1.length*3){
            if(sum==total) return answer;
            if(sum>total){
                int t = q1.poll();
                sum-=t;
                q2.add(t);
                answer++;
            }else if(sum<total){
                int t = q2.poll();
                sum+=t;
                q1.add(t);
                answer++;
            }
        
        }
        return -1;
        
    }
}