import java.util.*;

class Solution {
    static boolean[] visited;
    ArrayList<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        dfs("ICN","ICN",0,tickets);
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    public void dfs(String start, String route, int cnt, String[][] tickets){
        if(cnt == tickets.length){
            list.add(route);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!visited[i]&& start.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets[i][1],route+" "+tickets[i][1],cnt+1,tickets);
                visited[i] = false;
            }
        }
    }
}