import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);

    	int N = scan.nextInt();
    	
    	Queue<Integer> q = new LinkedList<>();
    	
    	for(int i=1;i<=N;i++) {
    		q.add(i);
    	}
    	
    	while(q.size()!=1) {
    		q.poll();
    		if(q.size()==1)break;
    		q.offer(q.poll());
    	}
    	
    	System.out.println(q.peek());
    }
}