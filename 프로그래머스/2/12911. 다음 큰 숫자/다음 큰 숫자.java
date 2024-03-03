import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = binary(n);
        int idex = 1;
        while(true){
            int number = n + idex;
            if(cnt==binary(number)){
                answer = number;
                break;
            }
            idex++;
        }
        return answer;
    }
    public int binary(int num){
        String s = Integer.toBinaryString(num);
        int count = 0;
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='1')count++;
        }
        return count;
    }
}