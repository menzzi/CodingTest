import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String,Integer> map = new HashMap<>();
        int[] sum = new int[id_list.length];
        int[][] rep = new int[id_list.length][id_list.length];
        for(int i=0;i<id_list.length;i++){
            map.put(id_list[i],i);
        }
        
        for(int i=0;i<report.length;i++){
            String[] name = report[i].split(" ");
            if(rep[map.get(name[0])][map.get(name[1])]==0) sum[map.get(name[1])]++;
            rep[map.get(name[0])][map.get(name[1])]++;
        }
        
        for(int i=0;i<id_list.length;i++){
            int num = 0;
            for(int j=0;j<id_list.length;j++){
                if(i==j) continue;
                if(sum[j]>=k && rep[i][j]>=1){
                    num++;
                }
            }
            answer[i] = num;
        }
        return answer;
    }
}