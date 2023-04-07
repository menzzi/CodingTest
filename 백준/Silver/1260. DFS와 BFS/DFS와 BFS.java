import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	
	static int ground[][];
	static boolean check1[];
	static boolean check2[];
	static int N,M;
	//static Queue<Integer> count1 = new LinkedList<>();
	//static Queue<Integer> count2 = new LinkedList<>();
	
	static void dfs(int start) {
		
		check1[start] = true;
		System.out.print(start +" ");
		//count1.add(start);
		
		
		for(int i=1;i<=N;i++) {
			if(ground[start][i]==1 && !check1[i]) {
				dfs(i);
			}
		}
		
	}
	static void bfs(int start) {
		
		check2[start] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		
		while(!q.isEmpty()) {
			System.out.print(q.peek()+" ");
			int temp = q.poll();
			
			for(int i=1;i<=N;i++) {
				if(ground[temp][i]==1 && !check2[i]) {
					q.add(i);
					check2[i] = true;
				}
			}
			//System.out.print(q.poll()+" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		int start = scan.nextInt();
		
		ground = new int[1001][1001];
		check1 = new boolean[1001];
		check2 = new boolean[1001];
		
		for(int i=0;i<M;i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			ground[x][y] = 1;
			ground[y][x] = 1;
		}
		dfs(start);
		System.out.println();
		bfs(start);
	
	}	
}
