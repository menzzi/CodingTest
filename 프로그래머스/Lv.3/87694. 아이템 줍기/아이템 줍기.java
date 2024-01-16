import java.util.*;
class Solution {
    int[][] map;
    int[][] visited;
    int[] x = {1,0,-1,0};
    int[] y = {0,-1,0,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[102][102];
        visited = new int[102][102];
        for(int i=0;i<rectangle.length;i++){
            for(int j = rectangle[i][0]*2;j<=rectangle[i][2]*2;j++){
                for(int k = rectangle[i][1]*2;k<=rectangle[i][3]*2;k++){
                    map[j][k] = 1;
                }
            }
        }
        for(int i=0;i<rectangle.length;i++){
            for(int j = rectangle[i][0]*2+1;j<rectangle[i][2]*2;j++){
                for(int k = rectangle[i][1]*2+1;k<rectangle[i][3]*2;k++){
                    map[j][k] = 0;
                }
            }
        }
        
        answer = BFS(characterX,characterY,itemX,itemY);
        return answer/2;
    }
    public int BFS(int characterX, int characterY, int itemX, int itemY){
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX*2,characterY*2});
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int nx = poll[0];
            int ny = poll[1];
            
            for(int i=0;i<4;i++){
                int dx = nx + x[i];
                int dy = ny + y[i];
                
                if(dx<=0 || dy<=0 || dx >100 || dy >100) continue;
                
                if(visited[dx][dy]==0 && map[dx][dy] ==1){
                    q.add(new int[]{dx,dy});
                    visited[dx][dy] = visited[nx][ny] + 1;
                }
                if(dx==itemX*2 && dy==itemY*2) return visited[itemX*2][itemY*2];
            }
        }
        return visited[itemX*2][itemY*2];
    }
}