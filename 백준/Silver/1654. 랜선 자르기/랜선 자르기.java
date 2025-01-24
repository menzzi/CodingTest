import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long max = 0;
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if(arr[i] > max) {
                max = arr[i];
            }
        }

        max++;
        
        long min = 0;
        long mid = 0;
        
        while(min < max) {
            mid = (min + max) / 2;
            long count = 0;
            for(int i = 0;i < N; i++) {
                count += (arr[i] / mid);
            }

            if(count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}