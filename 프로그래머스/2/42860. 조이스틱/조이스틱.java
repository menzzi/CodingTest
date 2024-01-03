import java.lang.Math;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        int[] count = new int[name.length()];
        for(int i=0;i<name.length();i++){
            char c = name.charAt(i);
            if(c > 'M') count[i]= 'Z'-c +1;
            else count[i] = c-'A';
        }

        for(int i=0;i<name.length();i++){
            answer +=count[i];
            int index = i+1;
            while(index<name.length()&&count[index]==0){
                index++;
            }
            move = Math.min(move,i*2+name.length()-index);
            move = Math.min(move,(name.length()-index)*2+i);
        }
      
        answer+=move;
        return answer;
    }
}