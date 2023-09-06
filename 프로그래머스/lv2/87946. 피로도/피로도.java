import java.lang.Math;

class Solution {
    static boolean[] visited;
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        dfs(k,dungeons,0);
        
        return max;
    }
    public void dfs(int k,int[][] dungeons,int cnt){
        for(int i=0;i<dungeons.length;i++){
            if(visited[i] || k<dungeons[i][0]) continue;
            
            visited[i] = true;
            dfs(k-dungeons[i][1],dungeons,cnt+1);
            visited[i]=false;
        }
        
        max = Math.max(max,cnt);
    }
}