import java.util.*;

class Solution {
    static HashMap<String,List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        
        for(int i=0;i<info.length;i++){
            String[] s = info[i].split(" ");
            make(s,"",0);
        }
        
        for(String key:map.keySet()){
            Collections.sort(map.get(key));
        }
        for(int i=0;i<query.length;i++){
            query[i] = query[i].replaceAll(" and ","");
            String[] q = query[i].split(" ");
            if(map.containsKey(q[0])) {
                answer[i]=binarySearch(q[0],Integer.parseInt(q[1]));
            }else answer[i] = 0;
        }
        return answer;
    }
    
    public void make(String[] s,String str,int idx){
        if(idx==4){
            if(!map.containsKey(str)){
                List<Integer> list = new ArrayList<>();
                map.put(str,list);
            }
            map.get(str).add(Integer.parseInt(s[4]));
            return;
        }
        make(s,str+"-",idx+1);
        make(s,str+s[idx],idx+1);
    }
    
    public int binarySearch(String key, int score){
        List<Integer> li = map.get(key);
        int start = 0;
        int end = li.size()-1;
        while(start<=end){
            int mid = (start + end)/2;
            if(li.get(mid)<score){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return li.size()-start;
    }
}