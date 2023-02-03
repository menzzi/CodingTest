import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int TestCase = scan.nextInt();
        
        for(int i=0;i<TestCase;i++){
            
            int R = scan.nextInt();
            String str = scan.next();
            
            for(int j=0;j<str.length();j++){
                for(int k=0;k<R;k++) {
                	System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }    
 
    }


}