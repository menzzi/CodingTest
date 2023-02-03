import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int M = scanner.nextInt();
        int T = scanner.nextInt();
        H+=T/60;
        M+=T%60;
        
        if(M>=60){
            H++;
            M-=60;   
        }
         if(H>=24){
                H-=24;
            }
     
        System.out.printf("%d %d",H,M);
    }
}