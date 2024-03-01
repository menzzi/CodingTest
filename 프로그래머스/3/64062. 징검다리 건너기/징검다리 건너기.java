import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;
        while(min<=max){
            int mid = (min+max)/2;
            
            if(check(stones,mid,k)){
                min = mid+1;
                answer = mid;
            }else{
                max = mid -1;
            }
        }
        return answer;
    }
    public boolean check(int[] stones,int mid,int k){
        int step = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]<mid) step++; 
            else step = 0; // 건너뜀 없이 넘으면 꼭 초기화 해줘야한다.
            
            if(step==k)return false;
        }
        return true;
    }
}