import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        int answer = 0;
        int time = 0;
        int cnt = 0;
        int idx = 0;
        
        while(true){
            if(cnt == jobs.length) break;
            
            while(idx<jobs.length && jobs[idx][0] <= time){
                q.offer(jobs[idx++]);
            }
                
            if(!q.isEmpty()){
                int[] poll = q.poll();
                cnt++;
                answer += time - poll[0] + poll[1];
                time += poll[1];
            }else{
                time = jobs[idx][0];
            }
        }
        
        return answer/jobs.length;
    }
}