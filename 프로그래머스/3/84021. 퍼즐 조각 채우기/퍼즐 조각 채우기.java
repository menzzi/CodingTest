import java.util.*;
class Solution {
    static int[] x = {1,0,-1,0};
    static int[] y = {0,1,0,-1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        int size = table.length;
        
        boolean[][] visited_g = new boolean[size][size];
        boolean[][] visited_t = new boolean[game_board.length][game_board.length];
        List<List<int[]>> gameList = new ArrayList<>();
        List<List<int[]>> tableList = new ArrayList<>();
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(!visited_g[i][j] && game_board[i][j] == 0){
                    BFS(i,j,game_board,visited_g,0,gameList);
                }
                if(!visited_t[i][j] && table[i][j] == 1){
                    BFS(i,j,table,visited_t,1,tableList);
                }
            }
        }
        answer = isCheck(gameList,tableList);
        return answer;
    }
    
    public void BFS(int cx,int cy, int[][] board, boolean[][] visited,int isEmpty, List<List<int[]>> list){     
        Queue<int[]> q = new LinkedList<>();
        visited[cx][cy] = true;
        q.add(new int[]{cx,cy});
        List<int[]> subList = new ArrayList<>();
        subList.add(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] poll = q.remove();
            int dx = poll[0];
            int dy = poll[1];
            
            for(int i=0;i<4;i++){
                int nx = dx + x[i];
                int ny = dy + y[i];
                
                if(nx<0 || nx >=board.length || ny<0|| ny>=board.length)continue;
                if(!visited[nx][ny] && board[nx][ny]==isEmpty){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                    subList.add(new int[]{nx-cx,ny-cy});
                }
            }
        }
        list.add(subList);
    }
    
    public int isCheck(List<List<int[]>> game,List<List<int[]>> table){
        int result = 0;
        int size = table.size();
        boolean[] visitedgame = new boolean[game.size()];
        
        for(int i=0;i<size;i++){
            List<int[]> tablepoint = table.get(i);
            for(int j=0;j<game.size();j++){
                List<int[]> gamepoint = game.get(j);
                
                if(tablepoint.size()==gamepoint.size() && !visitedgame[j]){
                    if(isRotate(gamepoint,tablepoint)){
                        result += tablepoint.size();
                        visitedgame[j] = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
    
    public boolean isRotate(List<int[]> gp, List<int[]> tp){
        boolean result = false;
        
        gp.sort((o1, o2) -> Integer.compare(o1[0], o2[0]) != 0 ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        
        for(int i=0;i<4;i++){
             tp.sort((o1, o2) -> Integer.compare(o1[0], o2[0]) != 0 ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
            
            int nearZeroX = tp.get(0)[0];
            int nearZeroY = tp.get(0)[1];
            
            for(int j=0;j<tp.size();j++){
                tp.get(j)[0] -=nearZeroX;
                tp.get(j)[1] -=nearZeroY;
            }
            
            boolean isCollect = true;
            for(int j=0;j<gp.size();j++){
                int[] gpoint = gp.get(j);
                int[] tpoint = tp.get(j);
                
                if(gpoint[0] != tpoint[0] || gpoint[1] != tpoint[1]){
                    isCollect = false;
                    break;
                }
            }
            
            if(isCollect){
                result = true;
                break;
            }else{
                for(int j=0;j<tp.size();j++){
                    int tmp = tp.get(j)[0];
                    tp.get(j)[0] = tp.get(j)[1];
                    tp.get(j)[1] = -tmp;
                }
            }
            
        }
        return result;
    }
}