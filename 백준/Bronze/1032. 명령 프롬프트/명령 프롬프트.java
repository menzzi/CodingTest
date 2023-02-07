import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String[] str = new String[52];
		
		for(int i=0;i<N;i++) {
			str[i] = scan.next();
		}
		
		char[] arr = new char[str[0].length()];
		
		for(int i=0;i<str[0].length();i++) {
			arr[i] = str[0].charAt(i);
		}
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<str[i].length();j++) {
				if(str[i].charAt(j) == arr[j]) {
					arr[j]=str[i].charAt(j);
				}
				else {
					arr[j]='?';
				}
			}
			
		}
		System.out.print(arr);
	}
}
