import java.util.*;
import java.io.*;

class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(findTriangle(N));
    }

    private static int findTriangle(int N) {
        int answer = -1;

        for(int i = 0; i < N - 2; i++) {
            if(arr[i] + arr[i+1] > arr[i+2]) answer = Math.max(answer, arr[i] + arr[i+1] + arr[i+2]);
        }
        return answer;
    }
}