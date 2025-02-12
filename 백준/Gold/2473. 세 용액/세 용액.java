import java.util.*;
import java.io.*;

class Main {
    static long[] arr;
    static long result = Long.MAX_VALUE;
    static long[] pick = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0; i < N - 2; i++) {
            compare(i);
        }

        Arrays.sort(pick);
        for(int i = 0; i < 3; i++) {
            System.out.print(pick[i] + " ");
        }
    }

    private static void compare(int index) {
        int left = index + 1;
        int right = arr.length - 1;

        while(left < right) {
            long sum = arr[left] + arr[right] + arr[index];
            long absSum = Math.abs(arr[left] + arr[right] + arr[index]);

            if(absSum < result) {
                pick[0] = arr[left];
                pick[1] = arr[right];
                pick[2] = arr[index];
                result = absSum;
            } else if(sum > 0){
                right --;
            } else{
                left++;
            }
        }
    }
}