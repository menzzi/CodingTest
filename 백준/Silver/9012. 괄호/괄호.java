import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);

    	int N = scan.nextInt();
    	
    	for(int i=0;i<N;i++) {
    		
    		System.out.println(stack(scan.next()));
    	
    		}
    	}
    public static String stack(String s) {
    	Stack st = new Stack();
    	for(int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
    		
    		if(c == '(') {
    			st.push(c);
    		}else if(st.isEmpty()) {
    			return "NO";
    		}else {
    			st.pop();
    		}
    	}
    	if(st.isEmpty())return "YES";
    	else return "NO";    
    	}
    
}