import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int zero = 0;
        int cnt = 0;
        
        for(int i=0;i<lottos.length;i++){
            map.put(lottos[i],0);
            if(lottos[i]==0)zero++;
        }
        if(zero == 6){
            answer[0] = 1;
            answer[1] = 6;
            return answer;
        }
        
        for(int i=0;i<win_nums.length;i++){
            if(map.containsKey(win_nums[i])){
                cnt++;
            }
        }
        if(cnt==6){
            answer[0] = 1;
            answer[1] = 1;
        }else if(cnt>1){
            answer[1] = 7-cnt;
            answer[0] = 7-cnt-zero;
        }else{
            answer[1] = 6;
            if(cnt+zero<2)answer[0] = 6;
            else answer[0] = 7-cnt-zero;
        }
      
        return answer;
    }
}