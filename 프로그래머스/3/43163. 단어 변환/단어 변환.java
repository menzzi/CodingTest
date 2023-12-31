import java.util.*;
import java.lang.Math;

class Solution {
    static int answer = 50;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        if(begin == target) return 1;
        dfs(begin,target,words,0);
        if(answer == 50) return 0;
        return answer;
    }
    
    public boolean diff(String a,String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) count++;
        }
        if(count == 1) return true;
        return false;
    }
    
    public void dfs(String current, String target, String[] words, int step){
        if(answer <= step) return;
        if(current.equals(target)) {
            answer = Math.min(step,answer);
            return;
        }
        for(int i=0;i<words.length;i++){
            if(diff(current,words[i]) && !visited[i]){
                visited[i] = true;
                dfs(words[i],target,words,step+1);
                visited[i] = false;
            }
        }
        return;
    }
}