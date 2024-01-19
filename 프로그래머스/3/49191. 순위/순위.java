import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] win = new int[n+1][n+1];
        for(int i=0;i<results.length;i++){
            win[results[i][0]][results[i][1]] = 1;
            win[results[i][1]][results[i][0]] = -1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(win[i][j]==1 && win[j][k]==1){
                        win[i][k] = 1;
                        win[k][i] = -1;
                    }
                    if(win[i][j] == -1 &&win[j][k]==-1){
                        win[i][k] = -1;
                        win[k][i] = 1;
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j=1;j<=n;j++){
                if(win[i][j]!=0)cnt++;
            }
            if(cnt == n-1)answer++;
        }
        return answer;
    }
}