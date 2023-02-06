import java.util.*;


public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N1=0,N2=0;
		
		int[] arr = new int[31];
		
		for(int i=1;i<=28;i++) {
			int N = scan.nextInt();
			for(int j=0;j<=30;j++) {
				if(N==j) {
					arr[j]=1;
				}
			}
			
		}
		
		for(int i=1;i<=30;i++) {
			if(arr[i]!=1){
				N1=i;
				break;
			}
		}
		
		for(int j=N1+1;j<=30;j++) {
			if(arr[j]!=1) {
				N2=j;
				break;
			}
		}
		
		System.out.println(N1);
		System.out.println(N2);
	}
}
