import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String str = scan.next();
		int result = Integer.parseInt(str,16);
		
		System.out.print(result);
	}
}
