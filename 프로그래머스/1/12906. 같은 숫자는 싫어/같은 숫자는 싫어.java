import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);
        
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]==arr[i])continue;
            else q.add(arr[i]);
        }
        int[] answer = new int[q.size()];
        int idx = 0;
        while(!q.isEmpty()){
            answer[idx++] = q.poll();
        }
        return answer;
    }
}