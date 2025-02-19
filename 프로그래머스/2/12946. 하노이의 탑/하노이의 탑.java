import java.util.*;

class Solution {
    static List<int[]> answer = new ArrayList<>();
    public List<int[]> solution(int n) {
        hanoi(1, 2, 3, n);
        return answer;
    }
    private void hanoi(int start, int mid, int end, int n) {
        if(n == 0) return;
        
        hanoi(start, end, mid, n - 1);
        answer.add(new int[]{start, end});
        hanoi(mid, start, end, n - 1);
    }
}