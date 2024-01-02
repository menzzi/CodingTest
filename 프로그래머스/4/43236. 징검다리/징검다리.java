import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int right = distance;
        int left = 0;
        
        Arrays.sort(rocks);
        
        while(left<=right){
            int mid = (left+right)/2;
            int remove = 0;
            int pre = 0;
            
            for(int i=0;i<rocks.length;i++){
                if(rocks[i]-pre<mid){
                    remove++;
                }else pre = rocks[i];
                if(remove>n)break;
            }
            if(distance - pre < mid && remove<=n)remove++;
            
            if(remove>n) right = mid -1;
            else{
                left = mid+1;
                answer = mid;
            } 
            
        }
        return answer;
    }
}