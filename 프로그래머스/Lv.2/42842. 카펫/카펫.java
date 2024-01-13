import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=Math.sqrt(yellow);i++){
            int m = i;
            int n = yellow/m;
            if(m*n==yellow)map.put(m,n);
        }
        Iterator<Integer> keys = map.keySet().iterator();
        while(keys.hasNext()){
            int key = keys.next();
            if(key*2+(map.get(key)+2)*2 == brown){
                answer[0] = map.get(key)+2;
                answer[1] = key+2;
                break;
            }
        }
        
        return answer;
    }
}