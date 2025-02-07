import java.util.*;
import java.io.*;

class Main {
    static int N;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(0);
            return;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int res = 0;
        while(!pq.isEmpty()) {
            if(pq.size() == 2) {
                int sum = pq.poll() + pq.poll();
                res += sum;
            } else {
                int sum = pq.poll() + pq.poll();
                res += sum;
                pq.add(sum);
            }
        }

        System.out.println(res);
    }
}