import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx = 0;
        PriorityQueue<int[]> wq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(jobs,(o1,o2)-> o1[0]-o2[0]);
        int time = jobs[0][0];
        
        while(idx<jobs.length || !wq.isEmpty()){
            while(idx<jobs.length && jobs[idx][0]<=time){
                wq.offer(jobs[idx]);
                idx++;
            }
            if(wq.isEmpty()){
                time = jobs[idx][0];
                wq.offer(jobs[idx]);
                idx++;
            }
            int[] work = wq.poll();
            time += work[1];
            answer += time - work[0];
        }
        
        return answer/jobs.length;
    }
}