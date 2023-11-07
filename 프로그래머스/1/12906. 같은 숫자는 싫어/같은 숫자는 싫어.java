import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        q.offer(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1])q.offer(arr[i]);
        }
        int i=0;
        answer = new int[q.size()];
        while(!q.isEmpty()){
            answer[i] = q.poll();
            i++;
        }

        return answer;
    }
}