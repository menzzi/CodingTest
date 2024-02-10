import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        StringBuilder sb = new StringBuilder();
        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<record.length;i++){
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter") || str[0].equals("Change")){
                map.put(str[1],str[2]);
            }
        }
        for(int i=0;i<record.length;i++){
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")){
                sb.append(map.get(str[1])+"님이 들어왔습니다."+":");
            }else if(str[0].equals("Leave")){
                sb.append(map.get(str[1])+"님이 나갔습니다."+":");
            }
        }
        String list = sb.toString();
        String[] answer = list.split(":");
        return answer;
    }
}