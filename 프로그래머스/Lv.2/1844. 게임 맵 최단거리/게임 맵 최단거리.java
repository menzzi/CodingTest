import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[] x = {1,0,-1,0};
        int[] y = {0,-1,0,1};
        int[][] cnt = new int[maps.length][maps[0].length];
        cnt[0][0] = 1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];
            
            for(int i=0;i<4;i++){
                int dx = cx + x[i];
                int dy = cy + y[i];
                
                if(dx>=maps.length || dx<0 || dy >=maps[0].length || dy<0)continue;
                
                if(maps[dx][dy]==1&&cnt[dx][dy]==0){
                    q.add(new int[]{dx,dy});
                    cnt[dx][dy] = cnt[cx][cy]+1;
                }
                if(dx == maps.length-1 && dy == maps[0].length-1) break;
            }
            
        }
        answer = cnt[maps.length-1][maps[0].length-1];
        if(answer == 0) return -1;
        return answer;
    }
   
}