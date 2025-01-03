import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] counts = new int[3];
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        
        
        for(int i = 0; i < answers.length; i++){
            if(student1[i % 5] == answers[i]) counts[0]++;
            if(student2[i % 8] == answers[i]) counts[1]++;
            if(student3[i % 10] == answers[i]) counts[2]++;
        }
        
        int max = -1;
        int maxCount = 0;
        for(int count : counts){
             if (count > max) {
                max = count;
                maxCount = 1;
            } else if (count == max) {
                maxCount++;
            }
        }
        
        int[] answer = new int[maxCount];
        int index = 0;
        for(int i = 0; i < counts.length; i++){
            if(max == counts[i]) {
                answer[index] = i+1;
                index++;
            }
        }
        
        return answer;
    }
}