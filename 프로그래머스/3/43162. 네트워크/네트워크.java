class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                answer++;
                DFS(n, computers, i);
            }
        }
        return answer;
    }
    
    private void DFS(int n, int[][] computers, int index) {
        visited[index] = true;
        
        for(int i = 0; i < n; i++){
            if(!visited[i] && computers[index][i] == 1){
                DFS(n,computers,i);
            }
        }
    }
}