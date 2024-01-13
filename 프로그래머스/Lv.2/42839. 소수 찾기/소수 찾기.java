import java.util.*;
class Solution {
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
    
        int answer = 0;
        rec("",numbers);
    
        Iterator<Integer> it = set.iterator();
        for(Integer num:set){
            if(prime(num))answer++;
        }
        return answer;
    }
    public void rec(String tmp,String number){
        if(!tmp.equals(""))set.add(Integer.parseInt(tmp));
        for(int i=0;i<number.length();i++){
            rec(tmp+number.charAt(i),number.substring(0,i)+number.substring(i+1));
        }
    }
    public boolean prime(int num){
        if(num==0||num==1)return false;
        int n = (int)Math.sqrt(num);
        for(int i=2;i<=n;i++){
            if(num%i==0)return false;
        }
        return true;
    }
}