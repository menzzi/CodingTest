import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int sum = 0;
        String num = scan.next();
        
        for(int i=0;i<N;i++){
            sum+=num.charAt(i)-48;
        }
        System.out.print(sum);
        }
    }