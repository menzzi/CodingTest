import java.util.HashSet;
import java.util.Iterator;
class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        rec("",numbers);
        
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int number = it.next();
            if(prime(number))answer++;
        }
        return answer;
    }
    public void rec(String tmp,String s){
        if(!tmp.equals(""))set.add(Integer.parseInt(tmp));
        for(int i=0;i<s.length();i++){
            rec(tmp+s.charAt(i),s.substring(0,i)+s.substring(i+1));
        }
    }
    public boolean prime(int num){
        if(num == 0 || num == 1) return false;
        int n = (int)Math.sqrt(num);
        for(int i = 2;i<=n;i++){
            if(num%i==0)return false;
        }
        return true;
    }
}