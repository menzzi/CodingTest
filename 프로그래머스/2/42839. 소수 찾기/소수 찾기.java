import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        StringBuilder sb = new StringBuilder();
        find(numbers, sb);
        answer = set.size();
        return answer;
    }
    
    private static void find(String numbers, StringBuilder sb) {
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                if(isPrime(sb.toString())) {
                    set.add(Integer.parseInt(sb.toString()));
                }
                find(numbers, sb);
                sb.setLength(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isPrime(String str) {
        int number = Integer.parseInt(str);
        
        if(number <= 1) return false;
        if(number == 2 || number == 3) return true;
        
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}