import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        HashMap<Integer,Stack<Integer>> map = new HashMap<>();
        Stack<Integer> basket = new Stack<>();
        for(int i = 0;i<board.length;i++){
            Stack<Integer> st = new Stack<>();
            for(int j=board.length-1;j>=0;j--){
                if(board[j][i]!=0)st.push(board[j][i]);
            }
            map.put(i+1,st);
        }
        for(int i=0;i<moves.length;i++){
            int num = moves[i];
            Stack<Integer> peekSt = map.get(num);
            if(!peekSt.isEmpty()){
                if(!basket.isEmpty()){
                    if(basket.peek()==peekSt.peek()){
                        answer+=2;
                        basket.pop();
                        peekSt.pop();
                    }else basket.push(peekSt.pop());
                }else basket.push(peekSt.pop());
                map.put(num,peekSt);
            }
        }
        return answer;
    }
}