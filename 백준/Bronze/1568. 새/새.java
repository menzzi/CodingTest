import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int cnt = 0;
		int num = N;
		
		for(int i=1;i<=N;i++) {
			if(num<i)i=1;
			num-=i;
			cnt++;
			if(num==0)break;
		}
		System.out.println(cnt);
	}
}
