import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        for(int i=0;i<n;i++){
            int work = pq.poll();
            if(work==0)return 0;
            pq.add(work-1);
        }
        while(!pq.isEmpty()){
            int v = pq.poll();
            answer+= v*v;
        }
        return answer;
    }
}