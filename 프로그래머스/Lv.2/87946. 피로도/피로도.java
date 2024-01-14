import java.util.*;

class Solution {
    int[] visited;
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];
        DFS(k,dungeons,0);
        return max;
    }
    public void DFS(int currentK,int[][] dungeons,int cnt){
        for(int i=0;i<dungeons.length;i++){
            if(currentK < dungeons[i][0] || visited[i]==1)continue;
            
            visited[i] = 1;
            DFS(currentK-dungeons[i][1],dungeons,cnt+1);
            visited[i] = 0;
        }
        max = Math.max(max,cnt);
    }
}