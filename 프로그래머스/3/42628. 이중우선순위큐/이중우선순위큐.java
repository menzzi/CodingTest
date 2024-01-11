import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        
        for(int i=0;i<operations.length;i++){
            String[] str = operations[i].split(" ");
            int num = Integer.parseInt(str[1]);
            
            if(str[0].equals("I")){
                maxq.add(num);
                minq.add(num);
            }else{
                if(num == 1){
                    minq.remove(maxq.poll());
                }else{
                    maxq.remove(minq.poll());
                }
            }
        }
        if(!maxq.isEmpty()&&!minq.isEmpty()){
            answer[0] = maxq.poll();
            answer[1] = minq.poll();
        }else if(maxq.size()==0 && minq.size()==0){
            answer[0] = 0;
            answer[1] = 0;
        }
        
        return answer;
    }
}