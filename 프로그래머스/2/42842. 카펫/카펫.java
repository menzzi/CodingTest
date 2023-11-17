class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=3;i<=brown+yellow;i++){
            int w = (brown+yellow)/i;
            if((w-2)*(i-2)==yellow){
                answer[0] = w;
                answer[1] = i;
                break;
            }
        }
        return answer;
    }
}