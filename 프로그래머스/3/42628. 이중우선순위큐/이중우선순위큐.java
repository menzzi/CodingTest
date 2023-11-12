import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        for(int i=0;i<operations.length;i++){
            String s = operations[i];
            StringTokenizer st = new StringTokenizer(s," ");
            String O = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(O.equals("I")){
                max.offer(num);
                min.offer(num);
            }else if(O.equals("D")){
                if(max.isEmpty())continue;
                if(num == 1){
                    int del = max.poll();
                    min.remove(del);
                }else if(num == -1){
                    int del = min.poll();
                    max.remove(del);
                }
            }
        }
        if(!max.isEmpty()){
            answer[0] = max.poll();
            answer[1] = min.poll();
        }else{
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}