import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int start = 1;
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if(!stack.isEmpty() && stack.peek() == number) {
                stack.pop();
                sb.append("-\n");
            } else if(number >= start) {
                for(int j = start; j <= number; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
                start = number + 1;
            } else if(stack.peek() < number) {
                System.out.println("NO");
                return;
            }
        }

        if(!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}