import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int money = 0;
        if(A==B&&B==C){
            money = 10000+ A*1000;
        }else if(A==B || A==C){
            money = 1000 + A*100;
        }else if(B==C){
            money = 1000+ B*100;
        }else{
            money = Math.max(Math.max(A,B),C)*100;
        }
        System.out.print(money);
    }
}