import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);
    	
    	int N = scan.nextInt();
    	
    	int first = 1;
    	int second = 1;
    	int num = 1;
    	
    	while(N>0) {
    		if(num % 2 !=0) {
    			first = num;
    			second = 1;
    			num--;
    			N--;
    			if(N<=0)break;
    			for(int i=0;i<num;i++) {
    				first--;
    				second++;
    				N--;
    				if(N<=0)break;
    			}
    			num+=2;
    		}else {
    			second = num;
    			first = 1;
    			num--;
    			N--;
    			if(N<=0)break;
    			for(int i=0;i<num;i++) {
    				first++;
    				second--;
    				N--;
    				if(N<=0)break;
    			}
    			num+=2;
    		}
    	}
    	System.out.println(first+"/"+second);
    }
}