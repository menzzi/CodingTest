import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;
        if(people[0]+people[1]>limit) return people.length;
        for(int i=people.length-1;i>=index;i--){
            answer++;
            if(people[i] + people[index] <= limit){
                index++;
            }
        }
        return answer;
    }
}