import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);

    	
    	int[][] arr = new int[15][15];
    	
    	for(int i=0;i<15;i++) {
   			arr[0][i] = i;
   			arr[i][1] = 1;
   		}
    		
		
   		for(int i=1;i<15;i++) {
   			for(int j=2;j<15;j++) {
    			arr[i][j] = arr[i-1][j]+arr[i][j-1];
    		}
   		}
   		
   		int T = scan.nextInt();
   		for(int i=0;i<T;i++){
   			int k = scan.nextInt();
   			int n = scan.nextInt();
   			System.out.println(arr[k][n]);
   		}
    	
    }
}