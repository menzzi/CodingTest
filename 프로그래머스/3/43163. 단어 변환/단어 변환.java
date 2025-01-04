import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        if(!Arrays.asList(words).contains(target)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()){
            String poll = queue.poll();
            if(poll.equals(target)) break;
            
            for(int i = 0; i < words.length ; i++){
                if(!visited[i] && isOneDifference(poll, words[i])){
                    visited[i] = true;
                    queue.add(words[i]);
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
    private boolean isOneDifference(String first, String second) {
        int count = 0;
        for(int i = 0; i < first.length() ; i++){
            if(first.charAt(i) != second.charAt(i)){
                count ++;
            }
            if(count > 1) return false;
        }
        if(count == 1) return true;
        return false;
    }
}