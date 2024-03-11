import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=B.length-1;i>=0;i--){
            dq.add(B[i]);
        }
        for(int i=B.length-1;i>=0;i--){
            int num = dq.pollFirst();
            if(A[i]<num){
                answer++;
            }else{
                dq.pollLast();
                dq.addFirst(num);
            }
        }
        
        return answer;
    }
}