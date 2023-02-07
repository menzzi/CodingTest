import java.util.Scanner;


public class Main{
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int m = scan.nextInt();
		int M = scan.nextInt();
		int T = scan.nextInt();
		int R = scan.nextInt();
		int cnt = 0;
		int sum = m;
		
		if(m+T>M) {
			
			System.out.println(-1);
			
		}else {
			while(N>0) {
				if(sum+T<= M) {
					sum+=T;
					cnt++;
					N--;
				}else {
					sum-=R;
					cnt++;
					if(sum<m)sum=m;
				}
			}
			System.out.println(cnt);
		}
	}
}
