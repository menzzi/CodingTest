import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);
    	
    	int N = scan.nextInt();
    	int result = N;
 
    	
    	for(int i=0;i< N;i++) {
    		int[] a = new int[26];
    		String str = scan.next();
    		
    		for(int j=0;j<str.length()-1;j++) {
    			
    			if(str.charAt(j)!=str.charAt(j+1)) {
    				
    				a[str.charAt(j)-'a'] = 1;

    				if(a[str.charAt(j+1)-'a']==1) {
    						result--;
    						break;
    				}
    			
    			}
    		}
    	}
    	System.out.println(result);
    }
}