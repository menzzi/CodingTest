import java.util.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<int[]> numbers = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            numbers.add(new int[] {a, b});
        }

        numbers.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int start = numbers.get(0)[0];
        int end = numbers.get(0)[1];
        int sum = 0;

        for(int i = 1; i < N; i++){
            int a = numbers.get(i)[0];
            int b = numbers.get(i)[1];
            if(b >= start & b <= end) {
                if(a <= start) {
                    start = a;
                }
            } else if( a <= end && a >= start) {
                if(b >= end) {
                    end = b;
                }
            } else {
                sum += Math.abs(end - start);
                start = a;
                end = b;
            }
        }
        sum += Math.abs(end - start);
        System.out.println(sum);
    }
}