import java.util.Scanner;
import java.util.Stack;

public class Main{
	
	static int ground[][];
	static boolean check[][];
	static int M,N;
	static int count;
	
	static void dfs(int startX, int startY) {
		
		check[startX][startY] = true;
		int[] X = {-1,0,1,0};
		int[] Y = {0,-1,0,1};
		
		for(int i=0;i<4;i++) {
			int x = startX + X[i];
			int y = startY + Y[i];
			
			if(x<0||x>=M||y<0||y>=N) {
				continue;
			}
			
			if(ground[x][y]==1 && !check[x][y]) {
				
				dfs(x,y);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int i=0;i<T;i++){
		
			int K;
			count=0;
			M = scan.nextInt();
			N = scan.nextInt();
			ground = new int[M][N];
			check = new boolean[M][N];
			
			K = scan.nextInt();
			
			for(int j=0;j<K;j++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				ground[x][y] = 1;
			}
			for(int m=0;m<M;m++) {
				for(int n=0;n<N;n++) {
					if(ground[m][n]==1 && !check[m][n]) {
						dfs(m,n);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
	}	
}
