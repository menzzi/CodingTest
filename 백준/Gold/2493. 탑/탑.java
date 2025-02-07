import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] result;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek()[0] < num) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                sb.append(0).append(" ");
            } else if(num < stack.peek()[0]) {
                sb.append(stack.peek()[1]).append(" ");
            }
            
            stack.push(new int[]{num, i+1});
        }

        System.out.println(sb);
    }
}