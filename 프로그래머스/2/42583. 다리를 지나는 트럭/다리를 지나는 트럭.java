import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int w = 0;
        int time = 0;
    
        if(bridge_length == 1) return truck_weights.length+1;
        if(truck_weights.length == 1)return bridge_length+1;
        
        for(int i=0;i<truck_weights.length;i++){
            
           while(true){
               if(q.isEmpty()){
                   q.offer(truck_weights[i]);
                   w += truck_weights[i];
                   time++;
                   break;
               }else if(q.size()==bridge_length){
                   w-=q.poll();
               }else{
                   if(w+truck_weights[i]>weight){
                       q.offer(0);
                       time++;
                   }else{
                       w+=truck_weights[i];
                       q.offer(truck_weights[i]);
                       time++;
                       break;
                   }
                   
               }
           }
        }
        
        return time + bridge_length;
    }
}