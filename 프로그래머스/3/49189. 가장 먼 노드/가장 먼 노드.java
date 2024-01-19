import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] map = new boolean[n+1][n+1];
        int[] count = new int[n+1];
        
        for(int i=0;i<edge.length;i++){
            map[edge[i][0]][edge[i][1]] = true;
            map[edge[i][1]][edge[i][0]] = true;
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int poll = q.poll();
            for(int i=2;i<n+1;i++){
                if(map[poll][i] && count[i]==0){
                    count[i] = count[poll]+1;
                    q.add(i);
                }
            }
        }
        int max = 0;
        for(int i=0;i<n+1;i++){
            if(max<count[i]){
                max = count[i];
                answer = 1;
            }else if(max == count[i]){
                answer++;
            }
        }
        return answer;
    }
}