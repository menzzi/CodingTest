import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int tmp = 0;
        for(int i=0;i<order.length;i++){
            if(tmp<order[i]){
                for(int j=tmp+1;j<=order[i];j++){
                    st.push(j);
                }
                tmp = order[i];
            }
            
            if(st.peek().intValue()==order[i]){
                st.pop();
                answer++;
            }else{
                return answer;
            }
        }
        
        return order.length;
    }
}