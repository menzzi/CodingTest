import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(arr,new Comparator<String>(){
            @Override
            public int compare(String num1,String num2){
                return (num2+num1).compareTo(num1+num2);                
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numbers.length;i++){
            sb.append(arr[i]);
        }
        answer = sb.toString();
        if(answer.startsWith("0")) return "0";
        return answer;
    }
}