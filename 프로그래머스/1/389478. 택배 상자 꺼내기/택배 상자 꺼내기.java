class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int N = (n - 1) / w;
        int[][] map = new int[N + 1][w];
        
        int number = 1;
        for(int i = 0; i <= N; i++) {
            if(i % 2 == 0){
                for(int j = 0; j < w; j++) {
                    map[i][j] = number;
                    number++;
                    if(number > n) break;
                }
            } else {
                for(int j = w - 1; j >= 0; j--) {
                    map[i][j] = number;
                    number++;
                    if(number > n) break;
                }
            }
        }
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < w; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        int L = (num - 1) % w;
        if(((num-1) / w % 2) == 1) {
            L = w - L - 1;
        }
        for(int i = (num-1) / w; i <= N; i++) {
            if(map[i][L] != 0) answer++;
        }
        
        return answer;
    }
}