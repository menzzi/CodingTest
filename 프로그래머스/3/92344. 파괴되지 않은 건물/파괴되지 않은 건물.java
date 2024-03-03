class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] sum = new int[N+1][M+1];
        for(int i=0;i<skill.length;i++){
            int w = skill[i][0];
            if(w==1){
                sum[skill[i][1]][skill[i][2]] += (skill[i][5] * (-1));
                sum[skill[i][1]][skill[i][4]+1] += skill[i][5];
                sum[skill[i][3]+1][skill[i][2]] += skill[i][5];
                sum[skill[i][3]+1][skill[i][4]+1] += (skill[i][5] * (-1));
            }else{
                sum[skill[i][1]][skill[i][2]] += skill[i][5];
                sum[skill[i][1]][skill[i][4]+1] += (skill[i][5] * (-1));
                sum[skill[i][3]+1][skill[i][2]] += (skill[i][5] * (-1));
                sum[skill[i][3]+1][skill[i][4]+1] += skill[i][5];
            }
        }
        for(int x=1;x<N;x++){
            for(int y=0;y<M;y++){
                sum[x][y] += sum[x-1][y];
            }
        }
        for(int y=1;y<M;y++){
            for(int x=0;x<N;x++){
                sum[x][y] += sum[x][y-1];
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]+sum[i][j]>0) answer++;
            }
        }
        
        return answer;
    }
}