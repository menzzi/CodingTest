class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                DFS(n, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void DFS(int n, int[][] computers, int index) {
        visited[index] = true;
        for(int i = 0; i < n; i++){
            if(computers[index][i] == 1 && !visited[i]){
                DFS(n, computers, i);
            }
        }
    }
}