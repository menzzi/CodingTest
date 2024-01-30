import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] L = {3,0};
        int[] R = {3,2};
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1){
                sb.append("L");
                L[0] = 0;
                L[1] = 0;
            }else if(numbers[i]==4){
                sb.append("L");
                L[0] = 1;
                L[1] = 0;
            }else if(numbers[i]==7){
                sb.append("L");
                L[0] = 2;
                L[1] = 0;
            }else if(numbers[i]==3){
                sb.append("R");
                R[0] = 0;
                R[1] = 2;
            }else if(numbers[i]==6){
                sb.append("R");
                R[0] = 1;
                R[1] = 2;
            }else if(numbers[i]==9){
                sb.append("R");
                R[0] = 2;
                R[1] = 2;
            }else if(numbers[i]==2||numbers[i]==5||numbers[i]==8||numbers[i]==0){
                int point = 0;
                if(numbers[i]==2)point = 0;
                else if(numbers[i]==5)point = 1;
                else if(numbers[i]==8)point = 2;
                else point = 3;
                
                if(Math.abs(R[0]-point)+Math.abs(R[1]-1)==Math.abs(L[0]-point)+Math.abs(L[1]-1)){
                    if(hand.equals("right")){
                        sb.append("R");
                        R[0]=point;
                        R[1]=1;
                    }else{
                        sb.append("L");
                        L[0]=point;
                        L[1]=1;
                    }
                }else if(Math.abs(R[0]-point)+Math.abs(R[1]-1)<=Math.abs(L[0]-point)+Math.abs(L[1]-1)){
                    sb.append("R");
                    R[0]=point;
                    R[1]=1;
                }else{
                    sb.append("L");
                    L[0]=point;
                    L[1]=1;
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}