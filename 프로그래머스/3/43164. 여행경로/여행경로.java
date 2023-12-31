import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        DFS("ICN","ICN",tickets,0);
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    public void DFS(String start,String route,String[][] tickets,int count){
        
        if(count == tickets.length){
            list.add(route);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(start.equals(tickets[i][0])&&!visited[i]){
                visited[i] = true;
                DFS(tickets[i][1],route+" "+tickets[i][1],tickets,count+1);
                visited[i] = false;
            }
        }
    }
    
}