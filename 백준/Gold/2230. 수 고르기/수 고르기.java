import java.util.*;
import java.io.*;

class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        for(int i = 0; i < N; i++) {
           numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);

        int p1 = 0;
        int p2 = 0;
        int minDiff = Integer.MAX_VALUE;
        while(p1 < numbers.length - 1) {
            int diff = Math.abs(numbers[p2] - numbers[p1]);

            if(diff >= M) {
                minDiff = Math.min(minDiff, diff);
                if(diff == M) {
                    System.out.println(minDiff);
                    return;
                } else if(diff > M) {
                    p1++;
                }
            } else {
                if(p2 < numbers.length - 1) p2++;
                else p1++;
            }
        }

        System.out.println(minDiff);
    }
}