class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] student = new int[n];
        
        for(int lostIndex : lost){
            student[lostIndex - 1]--;
        }
        
        for(int reserveIndex : reserve){
            student[reserveIndex - 1]++;
        }
        
        for(int i = 0;i < n;i++){
            if(student[i] == -1){
                if(i - 1 >= 0 && student[i-1] > 0){
                    student[i]++;
                    student[i-1]--;
                }else if(i + 1 < n && student[i+1] > 0){
                    student[i]++;
                    student[i+1]--;
                }
            }
        }
     
        for(int i = 0;i < n;i++){
            if(student[i] == -1) answer--;
        }
            
        return answer;
    }
}