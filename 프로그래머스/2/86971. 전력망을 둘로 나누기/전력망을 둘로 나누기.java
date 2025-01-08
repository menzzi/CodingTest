import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        int[][] map = new int[n+1][n+1];
        
        for(int i = 0; i < wires.length; i++){
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    map[j][i] = 0;
                    answer = Math.min(answer, calculateWire(map, i, n));
                    map[i][j] = 1;
                    map[j][i] = 1;
                }
            }
        }
        return answer;
    }
    
    private int calculateWire(int[][] map, int num, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        
        boolean[] visited = new boolean[n+1];
        visited[num] = true;
        int count = 1;
        
        while(!queue.isEmpty()){
            int poll = queue.poll();
            for(int i = 1; i <= n; i++){
                if(!visited[i] && map[poll][i] == 1){
                    count++;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return Math.abs(n - (2 * count));
    }
}