import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int w = 0;
        if(truck_weights.length == 1)return bridge_length+1;
        for(int i=0;i<truck_weights.length;i++){
            int truck = truck_weights[i];
            while(true){
               if(q.isEmpty()){
                   q.add(truck);
                   answer++;
                   w+=truck;
                   break;
               }else if(q.size()==bridge_length){
                   w-=q.poll();
               }else{
                   if(w+truck<=weight){
                       q.add(truck);
                       answer++;
                       w+=truck;
                       break;
                   }else{
                       q.add(0);
                       answer++;
                   }
               }
            }
        }
        answer += bridge_length;
        return answer;
    }
}