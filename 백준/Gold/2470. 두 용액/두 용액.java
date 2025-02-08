import java.util.*;
import java.io.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int right = N - 1;
        int left = 0;
        int[] result = {Integer.MAX_VALUE, 0, N - 1};

        while(left < right) {
            int num =  Math.abs(numbers[left] + numbers[right]);

            if(num < result[0]) {
                result[0] = num;
                result[1] = numbers[left];
                result[2] = numbers[right];
            }

            if(numbers[left] + numbers[right] < 0) {
                left++;
            } else{
                right--;
            }

        }
        System.out.println(result[1] + " " + result[2]);
    }
}