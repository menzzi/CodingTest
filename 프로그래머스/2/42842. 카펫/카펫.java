class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 1; i <= yellow; i++){
            if(yellow % i == 0){
                int num = ((yellow / i) + i) * 2 + 4;
                if(num == brown){
                    answer[0] = (yellow / i) + 2;
                    answer[1] = i + 2;
                    return answer;
                }
            }
        }
        return answer;
    }
}