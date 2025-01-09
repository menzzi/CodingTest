import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        if(!Arrays.asList(words).contains(target)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        
        queue.add(begin);
        depth.add(0);
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()) {
            String poll =  queue.poll();
            int pollDepth = depth.poll();
            
            if(poll.equals(target)) return pollDepth;
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && isOneDiff(poll, words[i])) {
                    visited[i] = true;
                    queue.add(words[i]);
                    depth.add(pollDepth + 1);
                }
            }
        }
        return 0;
    }
    
    private boolean isOneDiff(String first, String second) {
        int count = 0;
        for(int i = 0; i < first.length(); i++) {
            if(first.charAt(i) != second.charAt(i)) count++;
            if(count > 1) return false;
        }
        if(count == 1) return true;
        return false;
    }
}