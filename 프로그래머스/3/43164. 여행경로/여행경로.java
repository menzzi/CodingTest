import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        DFS(tickets, "ICN", "ICN", 0);
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    private void DFS(String[][] tickets, String start, String routes, int cnt) {
        if(cnt == tickets.length) {
            list.add(routes);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                DFS(tickets, tickets[i][1], routes + " " + tickets[i][1], cnt + 1);
                visited[i] = false;
            }
        }
    }
}