import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        
        while(left <= right){
            int mid = (left+right)/2;
            int remove = 0;
            int pre = 0;
            
            for(int i=0;i<rocks.length;i++){
                if(rocks[i]-pre<mid)remove++;
                else pre = rocks[i];
                
                if(remove>n) break;
            }
            if(distance-pre < mid && remove<=n)remove++;
            
            if(remove>n){
                right = mid - 1;
            }else{
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}