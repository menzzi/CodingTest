import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        String[] number = numbers.split("");
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 1; i <= number.length; i++) {
            recur(number, i, sb);
        }
        
        return set.size();
    }
    
    public void recur(String[] number, int len, StringBuilder sb) {
        if(len == sb.length()){
            int num = Integer.parseInt(sb.toString());
            if(isPrime(num)) {
                set.add(num);
            }
            return;
        }
        
        for(int j = 0; j < number.length; j++){
            if(!visited[j]) {
                sb.append(number[j]);
                visited[j] = true;
                recur(number, len, sb);
                visited[j] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
    private boolean isPrime(int num) {
        if(num <= 1) return false;
        if(num <= 3) return true;
        
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}