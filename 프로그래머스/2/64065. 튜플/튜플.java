import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer,Integer> map = new HashMap<>();
        s = s.substring(2,s.length()-2);
        s = s.replace("},{" , ",");
        String[] str = s.split(",");
        for(int i=0;i<str.length;i++){
            int num = Integer.parseInt(str[i]);
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] answer = new int[map.size()];
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        int k = 0;
        for(Integer key:keySet){
            answer[k] = key;
            k++;
        }
        return answer;
    }
}