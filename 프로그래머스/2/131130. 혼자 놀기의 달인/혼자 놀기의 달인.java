import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer> count = new ArrayList<>();
    
    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];
        for(int i = 0; i < cards.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                BFS(i, cards[i], cards);
            }
        }        
        if(count.size() == 1) {
            return 0;
        } else if(count.size() == 2) {
            return count.get(0) * count.get(1);
        } else {
            int max1 = count.get(0);
            int max2 = count.get(1);
            
            for(int i = 2; i < count.size(); i++) {
                int num = count.get(i);
                if(max1 < num && max2 < num) {
                    max1 = Math.max(max1, max2);
                    max2 = num;
                } else if(max1 < num) {
                    max1 = num;
                } else if(max2 < num) {
                    max2 = num;
                }
            }
            answer = max1 * max2;
        }
        return answer;
    }
    private void BFS(int index, int value, int[] cards) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {index, value});
        int cnt = 1;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(!visited[poll[1] - 1]) {
                visited[poll[1] - 1] = true;
                queue.add(new int[] {poll[1], cards[poll[1] - 1]});
                cnt++;
            }
        }
        count.add(cnt);
    }
}