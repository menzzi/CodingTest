import java.util.Scanner;
import java.util.Stack;

public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		
		int N = scan.nextInt();
		
		int start = 0;
		
		while(N --> 0) {
			int input = scan.nextInt();
			
			if(input>start) {
				for(int i=start+1;i<=input;i++) {
					st.add(i);
					sb.append('+').append('\n');
				}
				start = input;
			}else if(st.peek() != input) {
				System.out.println("NO");
				return;
			}
			
			st.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
}