class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        
        int[] now = {5,5};
        
        for(int i=0;i<dirs.length();i++){
            char ch = dirs.charAt(i);
            if(ch=='U'){
                if(now[1] >= 10)continue;
                else{
                    if(!visited[now[0]][now[1]][0]){
                        answer++;
                        visited[now[0]][now[1]][0] = true;
                        visited[now[0]][now[1]+1][1] = true;
                    }
                    now[1] += 1;
                }
            }else if(ch=='D'){
                if(now[1] <= 0)continue;
                else{
                    if(!visited[now[0]][now[1]][1]){
                        answer++;
                        visited[now[0]][now[1]][1] = true;
                        visited[now[0]][now[1]-1][0] = true;
                    }
                    now[1] -= 1;
                }
            }else if(ch=='R'){
                if(now[0]>=10)continue;
                else{
                    if(!visited[now[0]][now[1]][2]){
                        answer++;
                        visited[now[0]][now[1]][2] = true;
                        visited[now[0]+1][now[1]][3] = true;
                    }
                    now[0] += 1;
                }
            }else if(ch=='L'){
                if(now[0]<=0)continue;
                else{
                    if(!visited[now[0]][now[1]][3]){
                        answer++;
                        visited[now[0]][now[1]][3] = true;
                        visited[now[0]-1][now[1]][2] = true;
                    }
                    now[0] -= 1;
                }
            }
        }
        return answer;
    }
}