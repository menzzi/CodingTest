class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length - 1;
        
        for(int i = 0; i< length; i++){
            char target = name.charAt(i);
            if(target <= 'M'){
                answer += target - 'A';
            }else{
                answer += 'Z' - target + 1;
            }
            
            int index = i+1;
            while(index < length && name.charAt(index) == 'A') index++;
            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }
        answer += move;
        return answer;
    }
}