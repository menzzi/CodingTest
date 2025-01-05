import java.util.*;

class Solution {
    static final int[] dx = {1,0,-1,0};
    static final int[] dy = {0,1,0,-1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        int size = game_board.length;
        
        boolean[][] visited_g = new boolean[size][size];
        boolean[][] visited_t = new boolean[size][size];
        List<List<int[]>> gameList = new ArrayList<>();
        List<List<int[]>> tableList = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
             for(int j = 0; j < size; j++){
                if(!visited_g[i][j] && game_board[i][j] == 0){
                    BFS(i, j, game_board, 0, visited_g, gameList);
                }
                if(!visited_t[i][j] && table[i][j] == 1){
                    BFS(i, j, table, 1, visited_t, tableList);
                }
            }
        }
        return compare(gameList, tableList);
    }
    
    private void BFS(int x, int y, int[][] board, int empty, boolean[][] visited, List<List<int[]>> list) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        List<int[]> subList = new ArrayList<>();
        subList.add(new int[]{0,0});
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) continue;
                if(!visited[nx][ny] && board[nx][ny] == empty){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                    subList.add(new int[]{nx - x, ny - y});
                }
            }
        }
        list.add(subList);
    }
    
    private int compare(List<List<int[]>> gameList, List<List<int[]>> tableList) {
        int result = 0;
        boolean[] visited = new boolean[gameList.size()];
        
        for(List<int[]> tp : tableList) {
            for(int j = 0; j < gameList.size(); j++) {
                List<int[]> gamePoint = gameList.get(j);
                
                if(tp.size() == gamePoint.size() && !visited[j]) {
                    if(isRightPuzzle(tp, gamePoint)){
                        result += tp.size();
                        visited[j] = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isRightPuzzle(List<int[]> tablePoint, List<int[]> gamePoint) {
        gamePoint.sort((firstArray, secondArray) -> {
            int compareFirst = Integer.compare(firstArray[0], secondArray[0]);
            if (compareFirst != 0) {
                return compareFirst;
            }
            return Integer.compare(firstArray[1], secondArray[1]);
        });
        
        for(int i = 0; i < 4 ;i++) {
            boolean isCollect = true;
            
            tablePoint.sort((firstArray, secondArray) -> {
                int compareFirst = Integer.compare(firstArray[0], secondArray[0]);
                if (compareFirst != 0) {
                    return compareFirst;
                }
                return Integer.compare(firstArray[1], secondArray[1]);
            });
            
            int baseX = tablePoint.get(0)[0];
            int baseY = tablePoint.get(0)[1];
            for (int[] point : tablePoint) {
                point[0] -= baseX;
                point[1] -= baseY;
            }
            
            for(int j = 0; j < tablePoint.size(); j++) {
                if(tablePoint.get(j)[0] != gamePoint.get(j)[0] || tablePoint.get(j)[1] != gamePoint.get(j)[1]) {
                    isCollect = false;
                    break;
                }
            }
            
            if (isCollect) return true;

                
            for(int[] tp : tablePoint){
                int tmp = tp[0];
                tp[0] = tp[1];
                tp[1] = -tmp;
            }
        }
        return false;
    }
}