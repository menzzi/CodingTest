import java.util.*;

class Solution {
    static HashMap<String,Integer> map;
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0;i<orders.length;i++){
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = String.valueOf(c);
        }
        
        for(int i=0;i<course.length;i++){
            map = new HashMap<>();
            for(int j=0;j<orders.length;j++){
                StringBuilder sb = new StringBuilder();
                if(course[i]<=orders[j].length()){
                    cal(orders[j],course[i],0,sb,0);
                }
            }
            int max = 0;
            for(Map.Entry<String,Integer> entry:map.entrySet()){
                max = Math.max(max,entry.getValue());
            }
            
            if(max>=2){
                for(Map.Entry<String,Integer> entry:map.entrySet()){
                    if(entry.getValue()==max){
                        answer.add(entry.getKey());
                    }
                }
            }
            
        }
        Collections.sort(answer);
        return answer;
    }
    public static void cal(String str,int n,int idx,StringBuilder sb,int cnt){
        if(cnt==n){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return;
        }
        for(int i=idx;i<str.length();i++){
            sb.append(str.charAt(i));
            cal(str,n,i+1,sb,cnt+1);
            sb.delete(cnt,cnt+1);
        }
    }
}