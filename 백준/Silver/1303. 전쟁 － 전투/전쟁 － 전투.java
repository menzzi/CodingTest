import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	static char[][] ground;
	static boolean check[][];
	static int N,M;
	static int count;
	static int Wresult,Bresult;
	
	static void dfs(int starti,int startj) {
		
		check[starti][startj] = true;
		count++;
		
		int[] X = {-1,0,+1,0};
		int[] Y = {0,-1,0,+1};
		
		for(int i=0;i<4;i++) {
			
			int x = starti+X[i];
			int y = startj+Y[i];
			
			if(x<0||x>=M||y<0||y>=N||check[x][y])continue;

			if(ground[starti][startj]==ground[x][y]) {
				check[x][y] = true;
				dfs(x,y);
			}
			
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String[] input = br.readLine().split(" ");
	     N = Integer.parseInt(input[0]); M = Integer.parseInt(input[1]);
	     ground = new char[M][N]; check = new boolean[M][N];
	     for(int i=0;i<M;i++)
	    	 ground[i] = br.readLine().toCharArray();
	        

	        
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
                    
					count=0;
					dfs(i,j);
					
					char ch = ground[i][j];
					
					if(ch=='W')Wresult+=count*count;
					else Bresult += count*count;

				}		
			}
		}
		System.out.println(Wresult +" "+ Bresult);
	}
		
}	

