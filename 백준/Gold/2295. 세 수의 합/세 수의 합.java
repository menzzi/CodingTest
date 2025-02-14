import java.util.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = N - 1; i > 0; i--) {
            for(int j = 0; j < N; j++) {
                int k = numbers[i] - numbers[j];
                if(set.contains(k)) {
                    max = Math.max(max, numbers[i]);
                }
            }
        }
        System.out.println(max);
    }
}