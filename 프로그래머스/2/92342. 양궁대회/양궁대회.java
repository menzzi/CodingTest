import java.util.*;

class Solution {
    int max = -1000;
    static int[] answer = {-1};
    static int[] lion;
  
    public void DFS(int n, int[] info,int cnt){
        if(cnt==n){
            int lionP = 0;
            int apeachP = 0;
            for(int i=0;i<=10;i++){
                if(info[i]!=0 ||lion[i]!=0){
                    if(lion[i]>info[i])lionP += 10-i;
                    else apeachP += 10-i;
                }
            }
            if(lionP > apeachP){
                if(lionP-apeachP >= max){
                    answer = lion.clone();
                    max = lionP-apeachP;
                }
            }
            return;
        }
        for(int i=0;i<=10 && lion[i]<=info[i];i++){
            lion[i]+=1;
            DFS(n,info,cnt+1);
            lion[i]-=1;
        }
    }
      public int[] solution(int n, int[] info) {
        lion = new int[11];
        DFS(n,info,0);
        return answer;
    }
}