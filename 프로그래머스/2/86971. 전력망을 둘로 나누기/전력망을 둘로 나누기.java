import java.util.*;

class Solution {
    static int[][] map; 
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        map = new int[n+1][n+1];
        
        for(int i = 0; i < wires.length; i++){
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
       for(int i = 0; i < wires.length; i++){
            map[wires[i][0]][wires[i][1]] = 0;
            map[wires[i][1]][wires[i][0]] = 0;
            answer = Math.min(answer, findConnect(n, wires[i][0]));
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        return answer;
    }
    
    private int findConnect(int n, int wire){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(wire);
        
        visited = new boolean[n+1];
        int count = 1;
        
        while(!queue.isEmpty()){
            int poll = queue.poll();
            visited[poll] = true;
            for(int i = 1; i <= n ;i++){
                if(visited[i])continue;
                if(map[poll][i] == 1){
                    queue.add(i);
                    count++;
                }
            }
        }
        return Math.abs(n - 2*count);
    }
}