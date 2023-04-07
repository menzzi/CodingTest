import java.util.Arrays;
import java.util.Scanner;

public class Main{
	
	static int ground[][];
	static boolean check[][];
	static int N,home=0,num;
	static int count[] = new int[25*25];
	
	static void dfs(int starti,int startj) {
		
		check[starti][startj] = true;
		count[home]++;
	
		int[] X = {-1,0,1,0};
		int[] Y = {0,-1,0,1};
		
		for(int i=0;i<4;i++) {
			int x = starti+X[i];
			int y = startj+Y[i];
			
			if(x<0||x>=N||y<0||y>=N)continue;
			
			if(ground[x][y]==1 && !check[x][y]) {
				dfs(x,y);
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		ground = new int[N+1][N+1];
		check = new boolean[N+1][N+1];

		
		for(int i=0;i<N;i++) {
			String str = scan.next();
			for(int j=0;j<N;j++) {
				ground[i][j] = str.charAt(j)-'0';
				//-'0' 하면 String형 숫자를 int형 숫자로!!
			}
		}
		num=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(ground[i][j]==1 && !check[i][j]) {
					dfs(i,j);
					home++;
					
				}
			}
		}
		Arrays.sort(count);
		System.out.println(home);
		for(int i=0;i<count.length;i++) {
			if(count[i]!=0) {
				System.out.println(count[i]);
			}
		}
	
	}	
}
