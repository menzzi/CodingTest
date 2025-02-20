import java.util.*;

class Solution {
    static int[] p = new int[3];
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        for(int i = 0; i < picks.length; i++) {
            p[i] = picks[i];
        }
        DFS(minerals, 0, 0);
        return answer;
    }
    
    private void DFS(String[] minerals, int sum, int index) {
        if(isEmpty() || index > minerals.length - 1) {
            answer = Math.min(answer, sum);
            return;
        }
        
        for(int j = 0; j < 3; j++) {
            if(p[j] > 0) {
                p[j]--;
                int tmp = removeMinerals(j, index, minerals);
                DFS(minerals, sum + tmp, index + 5);
                p[j]++;
            }
        }
    }
    
    private boolean isEmpty() {
        for(int i = 0; i < 3; i++) {
            if(p[i] != 0) return false;
        }
        return true;
    }
    
    private int removeMinerals(int j, int index, String[] minerals) {
        int sum = 0;
        for(int i = index; i < index + 5; i++) {
            if(i > minerals.length - 1) return sum;
            
            if(minerals[i].equals("diamond")) {
                if(j == 0) sum++;
                else if(j == 1) sum += 5;
                else sum += 25;
            } else if(minerals[i].equals("iron")) {
                if(j == 2) sum += 5;
                else sum++;
            } else {
                sum++;
            }
        }
        return sum;
    }
}