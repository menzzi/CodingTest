import java.util.*;

class Solution {
    int[][] map;
    int[] visited;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n+1][n+1];
        for(int i=0;i<wires.length;i++){
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        for(int i=0;i<wires.length;i++){
            map[wires[i][0]][wires[i][1]] = 0;
            map[wires[i][1]][wires[i][0]] = 0;
            answer = Math.min(answer,BFS(n,wires[i][0]));
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        return answer;
    }
    public int BFS(int n,int a){
        int cnt = 1;
        visited = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        while(!q.isEmpty()){
            int poll = q.poll();
            visited[poll] = 1;
            for(int i=1;i<=n;i++){
                if(visited[i]==1)continue;
                else if(map[poll][i]==1){
                    q.offer(i);
                    cnt++;
                }
            }
        }
        return Math.abs(n-2*cnt);
    }
}