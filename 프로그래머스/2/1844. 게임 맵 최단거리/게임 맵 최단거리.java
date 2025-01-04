import java.util.*;

class Solution {
    int[] rows = {0,1,0,-1};
    int[] columns = {1,0,-1,0};
    public int solution(int[][] maps) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[maps.length][maps[0].length];
        queue.add(new int[]{0,0});
        visited[0][0] = 1;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];
            
            for(int i = 0; i < 4; i++){
                int curR = r + rows[i];
                int curC = c + columns[i];
                
                if(curC >= maps[0].length || curC < 0 || curR >= maps.length || curR < 0) continue;
                
                if(visited[curR][curC] == 0 && maps[curR][curC] == 1){
                    queue.add(new int[]{curR, curC});
                    visited[curR][curC] = visited[r][c] + 1;
                }
                
                if(curR == maps.length-1 && curC == maps[0].length-1) break;
            }
        }
        answer = visited[maps.length-1][maps[0].length-1];
        if(answer == 0) return -1;
        return answer;
    }
}