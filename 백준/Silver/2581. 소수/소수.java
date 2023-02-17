import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);

    	int M = scan.nextInt();
    	int N = scan.nextInt();
    	int result = 0;
    	int min = N;
    	
    	for(int i=M;i<=N;i++) {
    		int count = 0;
    		for(int j=1;j<=i;j++) {
    			if(i%j==0)count++;
    		}
    		if(count==2) {
    			result+=i;
    			if(i<min)min=i;
    		}
    	}
    	if(result == 0)System.out.println(-1);
    	else {
    		System.out.println(result);
    		System.out.println(min);
    	}
    	
    }
}