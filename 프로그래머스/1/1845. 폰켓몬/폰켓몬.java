import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length/2;
        HashMap<Integer,Integer> hash = new HashMap();
        for( int i=0;i<nums.length;i++){
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
        }
        if(hash.size() >size)answer=size;
        else answer = hash.size();
        return answer;
    }
}