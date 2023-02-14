import java.util.*;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);
    	
    	int N = scan.nextInt();
    	
    	int a = scan.nextInt();
    	int b = scan.nextInt();
    	int result = 0;
    	
    	while(true) {
    		
    		if(a%2!=0) {
    			if(b==a+1) {
    				result++;
    				break;
    			}
    			a=(a+1)/2;
    			result++;
    			if(b%2!=0)b=(b+1)/2;
    			else b=b/2;
    			
    		}else {
    			if(b==a-1) {
    				result++;
    				break;
    			}
    			a=a/2;
    			result++;
    			if(b%2!=0)b=(b+1)/2;
    			else b=b/2;
    			
    		}
    	}
    	System.out.print(result);
    }
}