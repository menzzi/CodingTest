import java.util.*;

class Solution {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        
        for(int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for(int x = x1; x <= x2; x++) {
                for(int y = y1; y <= y2; y++) {
                    if(map[x][y] == -1) continue;
                    if(x == x1 || x == x2 || y == y1 || y == y2) {
                        map[x][y] = 1;
                        continue;
                    }
                    map[x][y] = -1;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX * 2, characterY * 2, 0});
        
        boolean[][] visited = new boolean[101][101];
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int cnt = poll[2];
            if(x == itemX * 2 && y == itemY * 2) return cnt / 2;
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt + 1});
                }
            }
            
        }
        return -1;
    }
}