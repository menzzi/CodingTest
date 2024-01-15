class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer++;
                DFS(i,n,computers);
            }
        }
        return answer;
    }
    public void DFS(int idx,int n,int[][] computers){
        visited[idx] = true;
        for(int i=0;i<n;i++){
            if(!visited[i]&&computers[idx][i]==1){
                DFS(i,n,computers);
            }
        }
    }
}