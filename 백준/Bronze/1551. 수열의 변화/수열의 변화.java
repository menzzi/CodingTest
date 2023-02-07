import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		String str = scan.next();
		String[] s = str.split(",");
		
		int[] newStr = new int[str.length()];
		
		for(int j=0;j<s.length;j++) {
			newStr[j] = Integer.parseInt(s[j]);
		}
		
		for(int i=0;i<K;i++) {
			for(int j=0;j<N-1;j++) {
				newStr[j] = newStr[j+1]-newStr[j];
			}
			N--;
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(newStr[i]);
			if(i<N-1) {
				System.out.print(',');
			}
			
		}
	}
}
