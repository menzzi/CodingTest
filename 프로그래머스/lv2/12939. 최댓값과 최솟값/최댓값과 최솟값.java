import java.util.Arrays;
import java.lang.Math;

class Solution {
    public String solution(String s) {
        String answer = "";
        String arr[] = s.split(" ");
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            int num = Integer.parseInt(arr[i]);
            
            min = Math.min(min,num);
            max = Math.max(max,num);
            
        }
        
        
        answer = min+" "+max;
        
        return answer;
    }
}