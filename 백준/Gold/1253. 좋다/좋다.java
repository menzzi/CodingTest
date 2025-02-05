import java.util.*;
import java.io.*;

class Main {
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        int[] numbers = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < num; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int result = 0;

        for(int i = 0; i < num; i++) {
            int targetNum = numbers[i];
            int pt1 = 0;
            int pt2 = num - 1;

            while(pt1 < pt2) {
                if(numbers[pt1] + numbers[pt2] == targetNum) {
                    if(pt1 == i) {
                        pt1++;
                    } else if(pt2 == i) {
                        pt2--;
                    } else{
                        result++;
                        break;
                    }
                } else if(numbers[pt1] + numbers[pt2] > targetNum) {
                    pt2--;
                } else {
                    pt1++;
                }
            }
        }

        System.out.println(result);
    }
}