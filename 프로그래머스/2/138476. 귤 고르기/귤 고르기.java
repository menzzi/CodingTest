import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        List<Integer> entry = new ArrayList<>(map.keySet());
        entry.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        
        for(Integer key:entry){
            k -= map.get(key);
            answer++;
            if(k<=0)return answer;
        }
        return answer;
    }
}