import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int[] arr = new int[26];
        
        for(int i=0;i<str.length();i++){
            if('A'<=str.charAt(i) && str.charAt(i)<='Z'){
                arr[str.charAt(i)-'A']++;
            }else{
                arr[str.charAt(i)-'a']++;
            }
        }
        int Max = -1;
        char ch = '?';
        
        for(int i=0;i<26;i++){
            if(arr[i]>Max){
                Max = arr[i];
                ch = (char)(i+65);
            }else if(arr[i]==Max){
                ch='?';
            }
        }
        System.out.print(ch);
    }
}