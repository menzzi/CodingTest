import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                answer[0] = i%n +1;
                answer[1] = i/n +1;
                break;
            }else if(i!=0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = i%n +1;
                answer[1] = i/n +1;
                break;
            }else{
                map.put(words[i],1);
            }
        }
       

        return answer;
    }
}