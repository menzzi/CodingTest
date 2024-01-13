import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer =new int[3];
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        for(int j=0;j<answers.length;j++){
            if(answers[j]==a[j%5])answer[0]+=1;
            if(answers[j]==b[j%8])answer[1]+=1; 
            if(answers[j]==c[j%10])answer[2]+=1; 
        }
        int max = Math.max(answer[2],Math.max(answer[1],answer[0]));
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<3;i++){
            if(max==answer[i]){
                q.add(i+1);
            }
        }
        
        int[] ans = new int[q.size()];
        int idx = 0;
        while(!q.isEmpty()){
            ans[idx] = q.poll();
            idx++;
        }
        return ans;
    }
}