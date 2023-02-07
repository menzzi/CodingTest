import java.util.*;


public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int i=0;i<T;i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int num = 1;
			for(int j=0;j<b;j++) {
				num*=a;
				num%=10;
			}
			int result = num%10;
			if(result==0)result=10;
			System.out.println(result);
			
		}
	}
}
