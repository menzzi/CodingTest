import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String,String> map = new HashMap<>();
        HashMap<String,Integer> earn = new HashMap<>();
        
        for(int i=0;i<enroll.length;i++){
            map.put(enroll[i],referral[i]);
            earn.put(enroll[i],0);
        }
        
        for(int i=0;i<seller.length;i++){
            String person = seller[i];
            int money = amount[i]*100;
            int percent = money/10;
            int earning = money - percent;
            
            earn.put(person,earn.getOrDefault(person,0)+earning);
            while(!map.get(person).equals("-")){
                person = map.get(person);
                if(money==0)break;
                else money/=10;
                percent = money/10;
                earning = money - percent;

                earn.put(person,earn.get(person)+earning);
            }
        }
        for(int i=0;i<enroll.length;i++){
            answer[i] = earn.get(enroll[i]);
        }
        return answer;
    }
}