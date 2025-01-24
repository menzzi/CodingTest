import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;

        for(int i = 0; i < N; i++) {
            int num = convertToInt(str.charAt(i));
            long powNum = pow(31, i);

            answer += ((long)num * powNum) % 1234567891;
        }
        System.out.println(answer);
    }

    private static int convertToInt(char a) {
        return a - 'a' + 1;
    }

    private static long pow(int r, int index) {
        if(index == 0) return 1;
        long res = pow(r, index/2);

        if(index % 2 == 0) {
            return res * res;
        }else {
            return res * res * r;
        }
    }
}