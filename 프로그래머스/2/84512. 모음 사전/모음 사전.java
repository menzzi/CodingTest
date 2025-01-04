import java.util.*;

class Solution {
    static String[] alphabet = {"A","E","I","O","U"};
    static int count = 0;
    static int answer = 0;
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        recur(sb, word);
        return answer;
    }
    
    private void recur(StringBuilder sb, String word) {
        if(sb.toString().equals(word)) {
            answer = count;
            return;
        }
        
        if(sb.length() == 5) return;
        
        for(int i = 0; i < alphabet.length; i++){
            sb.append(alphabet[i]);
            count++;
            recur(sb, word);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}