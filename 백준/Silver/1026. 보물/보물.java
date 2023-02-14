import java.util.*;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);
    	
    	int N = scan.nextInt();
    	
    	int[] A = new int[50];
    	int[] B = new int[50];
    	
    	for(int i=0;i<N;i++) {
    		A[i] = scan.nextInt();
    	}
    	for(int i=0;i<N;i++) {
    		B[i] = scan.nextInt();
    	}
    	
    	for(int i=0;i<N;i++) {
    		for(int j=i+1;j<N;j++) {
    			if(B[i]<B[j]) {
    				int temp = B[j];
    				B[j] = B[i];
    				B[i] = temp;
    			}
    			
    		}
    	}
    	for(int i=0;i<N;i++) {
    		for(int j=i+1;j<N;j++) {
    			if(A[i]>A[j]) {
    				int temp = A[j];
    				A[j] = A[i];
    				A[i] = temp;
    			}
    			
    		}
    	}
    	int result = 0;
    	for(int i=0;i<N;i++) {
    		result+=A[i]*B[i];
    	}
    	
    	System.out.println(result);
    }
}