class Solution {
    public int solution(String arr[]) {
        int size = arr.length / 2 + 1;
        int[][] max = new int[size][size];
        int[][] min = new int[size][size];
        
        for(int i = 0; i < size; i++) {
            max[i][i] = Integer.parseInt(arr[i * 2]);
            min[i][i] = Integer.parseInt(arr[i * 2]);
        }
        
        for(int len = 1; len < size; len++) {
            for(int i = 0; i < size - len; i++) {
                int j = i + len;
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    String op = arr[k * 2 + 1];
                    int maxL = max[i][k];
                    int minL = min[i][k];
                    int maxR = max[k + 1][j];
                    int minR = min[k + 1][j];
                    
                    if(op.equals("+")) {
                        max[i][j] = Math.max(max[i][j], maxL + maxR);
                        min[i][j] = Math.min(min[i][j], minL + minR);
                    }else {
                        max[i][j] = Math.max(max[i][j], maxL - minR);
                        min[i][j] = Math.min(min[i][j], minL - maxR);
                    }
                }
            }
        }
        return max[0][size - 1];
    }
}