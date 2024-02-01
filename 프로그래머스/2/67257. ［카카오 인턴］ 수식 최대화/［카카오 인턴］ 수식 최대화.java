import java.util.*;

class Solution {
    String[][] op = {{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*","+"},{"*","+","-"},{"*","-","+"}};
    
    public long solution(String expression) {
        long answer = 0;
        ArrayList<String> list = new ArrayList<>();
        int start = 0;
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'){
                list.add(expression.substring(start,i));
                list.add(expression.charAt(i)+"");
                start=i+1;
            }
        }
        list.add(expression.substring(start));
        
        for(int i=0;i<op.length;i++){
            ArrayList<String> subList = new ArrayList<>(list);
            for(int j=0;j<3;j++){
                for(int k=0;k<subList.size();k++){
                    if(op[i][j].equals(subList.get(k))){
                        subList.set(k-1,cal(subList.get(k),subList.get(k-1),subList.get(k+1)));
                        subList.remove(k);
                        subList.remove(k);
                        k-=1;
                    }
                }
            }
            long result = Math.abs(Long.parseLong(subList.get(0)));
            answer = Math.max(answer,result);
        }
        return answer;
    }
    public String cal(String o,String num1,String num2){
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
        
        if(o.equals("+")) return n1+n2+"";
        else if(o.equals("-")) return n1-n2+"";
        return n1*n2+"";
    }
}