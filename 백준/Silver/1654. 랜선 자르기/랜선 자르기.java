import java.util.*;
import java.io.*;

class Main {
    static int K, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long max = 0;
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            max = Math.max(max, arr[i]);
        }
        max++;

        long min = 0;
        long mid = 0;
        while(min < max) {
            mid = (min + max) / 2;
            long count = 0;

            for(int i = 0; i < K; i++) {
                count += (arr[i] / mid);
            }

            if(count >= N) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }
}