class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return count;
    }
    
    public void DFS(int[] numbers, int target, int sum, int index) {
        if(index == numbers.length){
            if(target == sum){
                count++;
            }
            return;
        }
        DFS(numbers, target, sum + numbers[index], index + 1);
        DFS(numbers, target, sum - numbers[index], index + 1);
    }
}