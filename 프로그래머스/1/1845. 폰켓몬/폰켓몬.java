import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(nums.length/2 <= map.size()){
            return nums.length/2;
        }else{
            return map.size();
        }
        
    }
}