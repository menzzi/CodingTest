import java.util.*;

class Solution {
    static int[][] map;
    static int[][] visited;
    static int[][] count;
    static int[] x = {1,0,-1,0};
    static int[] y = {0,1,0,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[102][102];
        visited = new int[102][102];
        count = new int[102][102];
        characterX = characterX*2;
        characterY = characterY*2;
        itemX = itemX*2;
        itemY = itemY*2;
        
        for(int i=0;i<rectangle.length;i++){
            for(int x=rectangle[i][0]*2;x<=rectangle[i][2]*2;x++){
                for(int y=rectangle[i][1]*2;y<=rectangle[i][3]*2;y++){
                    map[x][y] = 1;
                }
            }
        }
        for(int i=0;i<rectangle.length;i++){
            for(int x=rectangle[i][0]*2+1;x<rectangle[i][2]*2;x++){
                for(int y=rectangle[i][1]*2+1;y<rectangle[i][3]*2;y++){
                    map[x][y] = 0;
                }
            }
        }
        visited[characterX][characterY] = 1;
        count[characterX][characterY] = 0;
        answer = BFS(characterX,characterY,itemX,itemY);
        return answer;
    }
    public int BFS(int cx,int cy, int ix,int iy){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{cx,cy});
        
        while(!q.isEmpty()){
            int[] n = q.remove();
            int nx = n[0];
            int ny = n[1];
            if(nx == ix && ny == iy) return count[nx][ny]/2;
            
            for(int i=0;i<4;i++){
                int dx = nx + x[i];
                int dy = ny + y[i];
                
                if(dx>1&&dx<=100&&dy>1&&dy<=100){
                    if(visited[dx][dy]==0 && map[dx][dy]==1){
                        q.add(new int[]{dx,dy});
                        count[dx][dy] = count[nx][ny]+1;
                        visited[dx][dy] = 1;
                    }
                }
            }
        }
        return 0;
    }
}