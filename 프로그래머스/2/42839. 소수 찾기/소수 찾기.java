import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] check = new boolean[7];
    
    public int solution(String numbers) {
        String tmp = "";
        for(int i = 1; i <= numbers.length(); i++){
            makeString(numbers,tmp,i);
        }
        int answer = set.size();
        return answer;
    }
    
    private boolean isPrime(int number){
        if(number < 2) return false;
        if(number < 4) return true;
//         if (number % 2 == 0 || number % 3 == 0) return false;
        
//         for(int i = 5; i * i <= number; i+=6){
//             if(number % i == 0 || number % (i+2) == 0) return false;
//         }
        
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    private void makeString(String n, String tmp, int length){
        if(tmp.length() == length){
            if(isPrime(Integer.parseInt(tmp))){
                set.add(Integer.parseInt(tmp));
            }
            return;
        }
        
        for(int j = 0; j < n.length(); j++){
            if(check[j]) continue;
            tmp += n.charAt(j);
            check[j] = true;
            makeString(n,tmp,length);
            check[j] = false;
            tmp = tmp.substring(0,tmp.length()-1);
        }
    }
}