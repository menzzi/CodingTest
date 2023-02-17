import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);

    	int[][] arr = new int[101][101];
    	int result = 0;
    	
    	int T = scan.nextInt();
    	for(int i=0;i<T;i++) {
    		int a = scan.nextInt();
    		int b = scan.nextInt();
    		for(int x=a;x<a+10;x++) {
    			for(int y=b;y<b+10;y++) {
    				arr[x][y]=1;
    			}
    		}
    	}
    	for(int x=1;x<101;x++) {
    		for(int y=1;y<101;y++) {
    			if(arr[x][y]==1)result+=1;
    		}
    	}
    	System.out.println(result);
    }
}