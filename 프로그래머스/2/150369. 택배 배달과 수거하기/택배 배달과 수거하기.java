import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> stackDel = new Stack<>();
        Stack<Integer> stackPick = new Stack<>();
        
        for(int i=0;i<n;i++){
            if(deliveries[i]!=0)stackDel.push(i);
            if(pickups[i]!=0)stackPick.push(i);
        }
        
        int del = cap;
        int pick = cap;
        while(!stackDel.isEmpty() && !stackPick.isEmpty()){
            if(stackDel.peek()>stackPick.peek()){
                answer+= 2*(stackDel.peek()+1);
            }else answer+= 2*(stackPick.peek()+1);
            
            while(del>0 && !stackDel.isEmpty()){
                int num  = deliveries[stackDel.peek()];
                if(num <= del){
                    del -= num;
                    stackDel.pop();
                }else{
                    deliveries[stackDel.peek()] = num - del;
                    del = 0;
                }
            }
            while(pick>0 && !stackPick.isEmpty()){
                int num  = pickups[stackPick.peek()];
                if(num <= pick){
                    pick -= num;
                    stackPick.pop();
                }else{
                    pickups[stackPick.peek()] = num - pick;
                    pick = 0;
                }
            }
            del = cap;
            pick = cap;
            
        }
        while(!stackDel.isEmpty()){
            answer += 2*(stackDel.peek()+1);
             while(del>0 && !stackDel.isEmpty()){
                int num  = deliveries[stackDel.peek()];
                if(num <= del){
                    del -= num;
                    stackDel.pop();
                }else{
                    deliveries[stackDel.peek()] = num - del;
                    del = 0;
                }
            }
            del = cap;
        }
        while(!stackPick.isEmpty()){
            answer += 2*(stackPick.peek()+1);
            while(pick>0 && !stackPick.isEmpty()){
                int num  = pickups[stackPick.peek()];
                if(num <= pick){
                    pick -= num;
                    stackPick.pop();
                }else{
                    pickups[stackPick.peek()] = num - pick;
                    pick = 0;
                }
            }
            pick = cap;
        }
        
        return answer;
    }
}