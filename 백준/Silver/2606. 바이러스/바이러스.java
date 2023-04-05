import java.util.Scanner;
import java.util.Stack;

public class Main{
	
	static int ground[][];
	static boolean check[];
	static int com;
	static int count;
	
	static void dfs(int start) {
		
		check[start] = true;
		count++;
		
		
		for(int i=1;i<=com;i++) {
			if(ground[start][i]==1 && !check[i]) {
				dfs(i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		com = scan.nextInt();
		count = 0;
		ground = new int[com+1][com+1];
		check = new boolean[com+1];
		int T = scan.nextInt();
		
		for(int i=1;i<=T;i++){
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			ground[x][y] = 1;
			ground[y][x] = 1;
			
		}
		dfs(1);
		System.out.println(count-1);
		
	}	
}
