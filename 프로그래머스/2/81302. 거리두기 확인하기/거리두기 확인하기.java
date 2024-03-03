import java.util.*;

class Solution {
    static int[] x = {1,0,-1,0};
    static int[] y = {0,-1,0,1};
    static char[][] map;
    static boolean[][] check;
    static boolean isTrue;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0;i<places.length;i++){
            map = new char[5][5];
            isTrue = false;
            
            for(int j=0;j<5;j++){
                map[j] = places[i][j].toCharArray();
            }
            
            for(int r=0;r<5;r++){
                for(int c=0;c<5;c++){
                    if(map[r][c]=='P'){
                        check = new boolean[5][5];
                        dfs(0,r,c);
                        if(isTrue)break;
                    }
                    if(isTrue)break;
                }
            }
            if(isTrue) answer[i] = 0;
            else answer[i] = 1;
        }
        return answer;
    }
    
    public void dfs(int depth,int r,int c){
        if(depth>=2)return;
        check[r][c] = true;
        for(int i=0;i<4;i++){
            int dx = r + x[i];
            int dy = c + y[i];
            
            if(dx<0 || dy <0||dx>=5||dy>=5||check[dx][dy]) continue;
            
            if(map[dx][dy]=='O')dfs(depth+1,dx,dy);
            else if(map[dx][dy]=='P'){
                isTrue = true;
                return;
            }
        }
    }
}