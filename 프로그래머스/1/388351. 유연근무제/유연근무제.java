class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int start = startday;
            int time = schedules[i] + 10;
            
            if((time/10) % 10 >= 6) {
                time += 100;
                time -= 60;
            }
            boolean flag = true;
            
            for(int j = 0; j < 7; j++) {
                if(start == 8) start = 1;
                if(start == 6 || start == 7) {
                    start++;
                    continue;
                }
                if(timelogs[i][j] > time) {
                    flag = false;
                    break;
                }
                start++;
            }
            if(flag) answer++;
        }
        return answer;
    }
}