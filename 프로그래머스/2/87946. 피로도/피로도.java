import java.util.*;

class Solution {
    static boolean visited[];
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        
        return answer;
    }
    public void dfs(int k,int[][] dungeons,int cnt){
        for(int i=0;i<dungeons.length;i++){
            if(visited[i] || k<dungeons[i][0])continue;
            visited[i] = true;
            dfs(k-dungeons[i][1],dungeons,cnt+1);
            visited[i] = false;
        }
        answer = Math.max(answer,cnt);
    }
}