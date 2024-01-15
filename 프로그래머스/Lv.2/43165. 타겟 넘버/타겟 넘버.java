class Solution {
    static int count;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        DFS(numbers,target,0,0);
        answer = count;
        return answer;
    }
    public void DFS(int[] numbers, int target,int sum,int idx){
        if(idx == numbers.length){
            if(sum==target)count++;
            return;
        }
        DFS(numbers,target,sum+numbers[idx],idx+1);
        DFS(numbers,target,sum-numbers[idx],idx+1);
    }
}