import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer;
        //1
        answer = new_id.toLowerCase();
        //2
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<answer.length();i++){
            char c = answer.charAt(i);
            if((c>='a' && c<='z')|| (c>='0' && c<='9')|| c == '-' || c == '_' || c == '.'){
                sb2.append(c);
            }
        }
        // 3
        answer = sb2.toString().replace("..", ".");
        while(answer.contains("..")){
            answer = answer.replace("..",".");
        }
        // 4
        if(answer.length()>0){
            if(answer.charAt(0)=='.'){
                answer = answer.substring(1,answer.length());
            }
        }
        if(answer.length()>0){
            if(answer.charAt(answer.length()-1)=='.'){
                answer = answer.substring(0,answer.length()-1);
            }
        }
        // 5
        if(answer.length() == 0)answer = "a";
        // 6
        if(answer.length()>15)answer = answer.substring(0,15);
        if(answer.charAt(answer.length()-1)=='.'){
            answer = answer.substring(0,answer.length()-1);
        }
        // 7
        StringBuilder sb3 = new StringBuilder(answer);
        if(answer.length()<=2){
            char cc = answer.charAt(answer.length()-1);
            while(sb3.length()<3){
                sb3.append(cc);
            }
        }
        answer = sb3.toString();
        return answer;
    }
}