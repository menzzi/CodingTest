import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int h = citations[citations.length-1];
        while(h>=0){
            int count = 0;
            for(int i=0;i<citations.length;i++){
                if(citations[i]>=h)count++;
            }
            if(count<h){
                h--;
            }else if(count>=h)break;
        }
        answer = h;
        return answer;
    }
}