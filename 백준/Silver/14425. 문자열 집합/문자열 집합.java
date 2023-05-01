import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){

        Set<String> set = new HashSet<>();

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int count = 0;

        for(int i=0;i<N;i++){
            set.add(scan.next());
        }

        for(int i=0;i<M;i++){
            String str = scan.next();

            if(set.contains(str))count++;
        }

        System.out.print(count);
    }
}