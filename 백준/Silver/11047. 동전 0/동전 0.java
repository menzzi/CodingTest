import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);

    	int N = scan.nextInt();
    	int K = scan.nextInt();
    	
    	Stack<Integer> st = new Stack<>();
    	
    	for(int i=1;i<=N;i++) {
    		int n = scan.nextInt();
    		if(n <= K) {
    			st.push(n);
    		}
    	}
    	
    	int cnt = 0;
    	
    	while(!st.isEmpty()) {
    		int coin = st.pop();
    		int cn = K/coin;
    		if(coin>K)continue;
    		cnt+=cn;
    		K-=cn*coin;
            if(K==0)break;
       		
    	}
    	System.out.print(cnt);
    	System.exit(0);
    }
}