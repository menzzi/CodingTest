import java.util.Arrays;
import java.util.Scanner;

public class Main{
	
	static int ground[][] = new int[51][51];
	static boolean check[][];
	static int w,h;
	static int island=0;
	
	static void dfs(int starti,int startj) {
		
		check[starti][startj] = true;
	
		int[] X = {-1,0,1,0,1,-1,1,-1};
		int[] Y = {0,-1,0,1,1,-1,-1,1};
		
		for(int i=0;i<8;i++) {
			int x = starti+X[i];
			int y = startj+Y[i];
			
			if(x<0||x>=h||y<0||y>=w)continue;
			
			if(ground[x][y]==1 && !check[x][y]) {
				dfs(x,y);
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			island=0;
			w = scan.nextInt();
			h = scan.nextInt();
			
			if(w==0 && h==0)break;
			
			ground = new int[h+1][w+1];
			check = new boolean[h+1][w+1];
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					ground[i][j] = scan.nextInt();
				}
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(ground[i][j]==1 && !check[i][j]) {
						dfs(i,j);
						island++;
					}
				}
			}
			System.out.println(island);
		}
	
	}	
}
