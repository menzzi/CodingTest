import java.util.*;

class Solution {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
        
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int i = 0; i < rectangle.length ; i++) {
            makeMap(rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2);
        }
        return BFS(characterX*2, characterY*2, itemX*2, itemY*2);
    }
    
    private int BFS(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX, characterY, 0});
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int cnt = poll[2];
            
            if(x == itemX && y == itemY) return cnt / 2;
            
            for(int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                
                if(cx > 100 || cx < 0 || cy > 100 || cy < 0) continue;
                
                if(!visited[cy][cx] && map[cy][cx] == 2) {
                    visited[cy][cx] = true;
                    queue.add(new int[]{cx,cy,cnt+1});
                }
            }
        }
        return -1;
    }
    
    private void makeMap(int x1, int y1, int x2, int y2) {
        for(int i = y1; i <= y2; i++) {
            for(int j = x1; j <= x2; j++) {
                if(map[i][j] == 1) continue;
                if(i == y1 || i == y2 || j == x1 || j == x2) {
                    map[i][j] = 2;
                    continue;
                }
                map[i][j] = 1;
            }
        }
    }
}