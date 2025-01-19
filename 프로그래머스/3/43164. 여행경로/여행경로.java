import java.util.*;

class Solution {
    static PriorityQueue<String> result = new PriorityQueue<>();
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        DFS(tickets, "ICN", "ICN", 0);
        
        return result.poll().split(" ");
    }
    
    private void DFS(String[][] tickets, String route, String departure, int cnt) {
        if(cnt == tickets.length){
            result.add(route);
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(departure)){
                visited[i] = true;
                DFS(tickets, route + " " + tickets[i][1], tickets[i][1], cnt + 1);
                visited[i] = false;
            }
        }
    }
}