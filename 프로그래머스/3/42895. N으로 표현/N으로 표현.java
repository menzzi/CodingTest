import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        List<Set<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++) {
            result.add(new TreeSet<>());
        }
        
        result.get(1).add(N);
        
        for(int i = 2; i < 9; i++) {
            result.get(i).add(Integer.parseInt(Integer.toString(N).repeat(i)));
            for(int j = 1; j < i; j++) {
                int k = i - j;
                for(int num1 : result.get(j)) {
                    for(int num2 : result.get(k)) {
                        result.get(i).add(num1 - num2);
                        result.get(i).add(num1 + num2);
                        result.get(i).add(num1 * num2);
                        if(num2 != 0) result.get(i).add(num1 / num2);
                    }
                }
            }
            if(result.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}