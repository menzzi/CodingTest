class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] board = new int[n+1][n+1];
        
        for(int i=0;i<results.length;i++){
            board[results[i][0]][results[i][1]] = 1;
            board[results[i][1]][results[i][0]] = -1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(board[i][j]==1 && board[j][k]==1){
                        board[i][k] = 1;
                        board[k][i] = -1;
                    }
                    if(board[i][j]==-1 && board[j][k]==-1){
                        board[i][k] = -1;
                        board[k][i] = 1;
                    }
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j=1;j<=n;j++){
                if(board[i][j]==0)cnt++;
            }
            if(cnt==1)answer++;
        }
        
        return answer;
    }
}