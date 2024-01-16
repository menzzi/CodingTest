import java.util.*;

class Solution {
    int[] visited;
    public int solution(String begin, String target, String[] words) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[words.length];
        for(int i=0;i<words.length;i++){
            if(diff(words[i],begin) && visited[i] == 0){
                q.add(i);
                visited[i] = 1;
            }
        }
        while(!q.isEmpty()){
            int poll = q.poll();
            if(words[poll].equals(target))return visited[poll];
            for(int i=0;i<words.length;i++){
                if(visited[i]==0 && diff(words[poll],words[i])){
                    q.add(i);
                    visited[i] = visited[poll] + 1;
                }
            }
        }
        return 0;
    }
    public boolean diff(String s1,String s2){
        int cnt = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))cnt++;
            if(cnt>=2)return false;
        }
        if(cnt==1)return true;
        else return false;
    }
}