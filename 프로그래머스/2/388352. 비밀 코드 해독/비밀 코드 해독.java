import java.util.*;

class Solution {
    static List<Set<Integer>> allCombinations = new ArrayList<>();
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        makeCombi(1, new HashSet<>(), n);
        
        for(int i = 0; i < q.length; i++) {
            int[] guess = q[i];
            int count = ans[i];
            List<Set<Integer>> filtered = new ArrayList<>();
            
            for(Set<Integer> combiSet : allCombinations) {
                int match = 0;
                for(int j = 0; j < 5; j++) {
                    if(combiSet.contains(guess[j])) match++;
                }
                if(match == count) {
                    filtered.add(combiSet);
                }
            }
            allCombinations = filtered;
            
        }
        return allCombinations.size();
    }
    
    private void makeCombi(int start, Set<Integer> set, int n) {
        if(set.size() == 5) {
            allCombinations.add(new HashSet<>(set));
            return;
        }
        for(int i = start; i <= n; i++) {
            set.add(i);
            makeCombi(i + 1, set, n);
            set.remove(i);
        }
    }
}