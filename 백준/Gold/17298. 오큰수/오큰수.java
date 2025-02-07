import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] numbers, result;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        numbers = new int[N];
        result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = N -1; i >= 0; i--) {
            int num = numbers[i];

            while(!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(num);
        }

        for(int number : result) {
            sb.append(number).append(" ");
        }
        System.out.println(sb);
    }
}