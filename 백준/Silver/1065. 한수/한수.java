import java.util.*;


public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int cnt = 0;
		
		if(N<100) {
			cnt = N;
			System.out.println(cnt);
		}else {
			cnt=99;
			
			for(int i=100; i<=N; i++) {
				int N1=i/100;
				int N2=(i/10)%10;
				int N3=i%10;
				if((N3-N2)==(N2-N1)) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
