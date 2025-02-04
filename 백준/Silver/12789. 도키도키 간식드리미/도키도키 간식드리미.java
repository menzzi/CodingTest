import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int index = 1;
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() == index) {
                stack.pop();
                index++;
            }

            if(index == number) {
                index++;
            } else {
                stack.push(number);
            }
        }

        while(!stack.isEmpty()) {
            if(stack.peek() != index) {
                System.out.println("Sad");
                return;
            }
            stack.pop();
            index++;
        }
        System.out.println("Nice");
    }
}