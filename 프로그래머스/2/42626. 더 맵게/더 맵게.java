import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            q.offer(scoville[i]);
        }
        while(q.peek()<K){
            if(q.size() == 1) return -1;
            int num1 = q.poll();
            if(num1 >= K) break;
            int num2 = q.poll();
            
            int num3 = num1 + num2 *2;
            q.offer(num3);
            answer++;
        }
        return answer;
    }
}