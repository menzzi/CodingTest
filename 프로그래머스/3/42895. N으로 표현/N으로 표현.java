import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        
        List<Set<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++){
            list.add(new TreeSet<>());
        }
        
        list.get(1).add(N);
        
        for(int i = 2; i <= 8; i++) { 
            list.get(i).add(Integer.parseInt(Integer.toString(N).repeat(i)));
            for(int j = 1; j < i; j++) {
                int k = i - j;
                for(int num1 : list.get(j)) {
                    for(int num2 : list.get(k)) {
                        list.get(i).add(num1 + num2);
                        list.get(i).add(num1 - num2);
                        list.get(i).add(num1 * num2);
                        if(num2 != 0) list.get(i).add(num1 / num2);
                    }
                }
            }
            if(list.get(i).contains(number)) return i;
        }
        return -1;
    }
}