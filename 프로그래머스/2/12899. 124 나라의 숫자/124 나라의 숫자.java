class Solution {
    public String solution(int n) {
        String answer = "";
        String[] str = {"1","2","4"};
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            int num = n%3;
            if(num==0){
                sb.insert(0,"4");
                n = n/3-1;
                
            }else{
                sb.insert(0,str[num-1]);
                n/=3;
            }
        }
        answer = sb.toString();
        return answer;
    }
}