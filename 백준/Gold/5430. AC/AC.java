import java.util.*;
import java.io.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deque;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            int num = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<Integer>();

            for(int j = 0; j < num; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isR = false;
            boolean flag = true;
            for(int k = 0; k < str.length(); k++) {
                if(str.charAt(k) == 'D') {
                    if(deque.isEmpty()) {
                        System.out.println("error");
                        flag = false;
                        break;
                    }
                    if(!isR) {
                        deque.poll();
                    }else {
                        deque.pollLast();
                    }
                }else {
                    isR = !isR;
                }
            }

            if(flag){
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while(!deque.isEmpty()) {
                    if(deque.size() == 1) {
                        sb.append(deque.poll());
                        break;
                    }
                    if(!isR) {
                        sb.append(deque.poll());
                        sb.append(",");
                    } else {
                        sb.append(deque.pollLast());
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}