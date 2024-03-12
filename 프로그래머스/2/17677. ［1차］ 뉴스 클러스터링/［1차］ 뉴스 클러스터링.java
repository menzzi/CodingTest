import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        for(int i=0;i<str1.length()-1;i++){
            String str = str1.substring(i,i+2);
            if(Character.isAlphabetic(str.charAt(0)) && Character.isAlphabetic(str.charAt(1)))
                map1.put(str,map1.getOrDefault(str,0)+1);
        }
         for(int i=0;i<str2.length()-1;i++){
            String str = str2.substring(i,i+2);
            if(Character.isAlphabetic(str.charAt(0)) && Character.isAlphabetic(str.charAt(1)))
                map2.put(str,map2.getOrDefault(str,0)+1);
        }
        int sum = 0;
        for(String key:map1.keySet()){
            sum += map1.get(key);
        }
        for(String key:map2.keySet()){
            sum += map2.get(key);
        }
        int intersection = 0;
        for(String key:map1.keySet()){
            if(map2.containsKey(key)){
                intersection+= Math.min(map1.get(key),map2.get(key));
            }
        }
        sum -= intersection;
        if(sum==0)return 65536;
        return intersection*65536 / sum;
    }
}