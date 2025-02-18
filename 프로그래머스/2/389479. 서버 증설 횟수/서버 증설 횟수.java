import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        
        int answer = 0;
        int server = 0;
        for(int i = 0; i < players.length; i++) {
            while(!pq.isEmpty() && pq.peek()[0] == i) {
                server -= pq.poll()[1];
            }
            
            int need = players[i] / m;
            int add = need - server;
            
            if(add > 0) {
                pq.add(new int[] {i + k, add});
                answer += add;
                server += add;
            }
        }
        return answer;
    }
}