import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            String answer = "YES";
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '(') {
                    stack.push('(');
                }else {
                    if(stack.isEmpty()) {
                        answer = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) answer = "NO";
            System.out.println(answer);
        }
    }
}