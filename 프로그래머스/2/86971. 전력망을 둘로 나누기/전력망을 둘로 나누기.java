import java.util.*;

class Solution {
    static int[][] graph;
        
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n+1][n+1];
        
        for(int i=0;i<wires.length;i++){
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;
        }
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a][b] = 0;
            graph[b][a] = 0;
            
            answer = Math.min(answer,bfs(n,a));
            
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        
        return answer;
    }
    public int bfs(int n,int a){
        int[] visited = new int[n+1];
        int cnt = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        
        while(!q.isEmpty()){
            int target = q.poll();
            visited[target] = 1;
            
            for(int i=1;i<=n;i++){
                if(visited[i]==1)continue;
                if(graph[target][i]==1){
                    q.offer(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(n-2*cnt);
    }
}