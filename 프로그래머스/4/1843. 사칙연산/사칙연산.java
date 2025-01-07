import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int size = arr.length / 2 + 1;
        int[][] maxMap = new int[size][size];
        int[][] minMap = new int[size][size];
        
        for(int i = 0; i < size; i++) {
            maxMap[i][i] = Integer.parseInt(arr[i * 2]);
            minMap[i][i] = Integer.parseInt(arr[i * 2]);
        }
        
        for(int len = 1; len < size; len++) {
            for(int i = 0; i < size - len ; i++) {
                int j = i + len;
                maxMap[i][j] = Integer.MIN_VALUE;
                minMap[i][j] = Integer.MAX_VALUE;
                
                for(int k = i; k < j; k++) {
                    String operator = arr[k * 2 + 1];
                    int maxLeft = maxMap[i][k];
                    int minLeft = minMap[i][k];
                    int maxRight = maxMap[k + 1][j];
                    int minRight = minMap[k + 1][j];
                    
                    if(operator.equals("+")){
                        maxMap[i][j] = Math.max(maxMap[i][j], maxLeft + maxRight);
                        minMap[i][j] = Math.min(minMap[i][j], minLeft + minRight);
                    }else{
                        maxMap[i][j] = Math.max(maxMap[i][j], maxLeft - minRight);
                        minMap[i][j] = Math.min(minMap[i][j], minLeft - maxRight);
                    }
                }
            }
        }
        return maxMap[0][size-1];
    }
}