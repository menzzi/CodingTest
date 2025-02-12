import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Integer> calculate = new Stack<>();
        Stack<Character> stack = new Stack<>();
        int cnt = 1;
        int answer = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                stack.push(ch);
                cnt *= 2;
            } else if(ch == '[') {
                stack.push(ch);
                cnt *= 3;
            } else if(ch == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                if(str.charAt(i-1) =='(') {
                    answer += cnt;
                }
                stack.pop();
                cnt /= 2;
            }else if(ch == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if(str.charAt(i-1) =='[') {
                    answer += cnt;
                }
                stack.pop();
                cnt /= 3;
            }
        }

        if(!stack.isEmpty()) {
            System.out.println(0);
        } else{
            System.out.println(answer);
        }
    }
}