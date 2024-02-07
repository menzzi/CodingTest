import java.util.*;
import java.text.SimpleDateFormat;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        String[] to = today.split("\\.");
        String year = to[0];
        String month = to[1];
        String day = to[2];
        for(int i=0;i<privacies.length;i++){
            String[] date = privacies[i].split(" ");
            for(int j = 0;j<terms.length;j++){
                String[] str = terms[j].split(" ");
                if(date[1].equals(str[0])){
                    String[] pr = date[0].split("\\.");
                    int n = Integer.parseInt(year)-Integer.parseInt(pr[0]);
                    n*=12;
                    n+= Integer.parseInt(month)-Integer.parseInt(pr[1]);
                    n*=28;
                    n+= Integer.parseInt(day)-Integer.parseInt(pr[2]);
                    if(n>= 28 * Integer.parseInt(str[1]))answer.add(i+1);
                }
            }
        }
        int[] ans = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}