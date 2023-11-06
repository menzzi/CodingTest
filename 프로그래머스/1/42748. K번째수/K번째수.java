import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int num = commands[i][1]-commands[i][0]+1;
            int[] input = new int[num];
            for(int j=0;j<num;j++){
                input[j] = array[j+commands[i][0]-1];
            }
            Arrays.sort(input);
            answer[i] = input[commands[i][2]-1];
        }
        
        return answer;
    }
}