import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < N ;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());

            if(num == 1) {
                int number = Integer.parseInt(st.nextToken());
                deque.addFirst(number);
            } else if(num == 2) {
                int number = Integer.parseInt(st.nextToken());
                deque.addLast(number);
            } else if(num == 3) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.poll());
            } else if(num == 4) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollLast());
            } else if(num == 5) {
                System.out.println(deque.size());
            } else if(num == 6) {
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if(num == 7) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peek());
            } else if(num == 8) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekLast());
            }
        }
    }
}