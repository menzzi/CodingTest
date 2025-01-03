import java.util.*;

class Solution {
    static int max = -1;
    static boolean[] check;
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        calculate(k, 0, dungeons);
        return max;
    }
    
    private void calculate(int k, int count, int[][] dungeons) {
        for(int i = 0;i < dungeons.length ; i++){
            if(k < dungeons[i][0] || check[i]) continue;
            check[i] = true;
            calculate(k - dungeons[i][1], count + 1, dungeons);
            check[i] = false;
        }
        max = Math.max(max, count);
    }
}