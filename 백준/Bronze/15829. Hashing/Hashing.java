import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;
        long pow = 1;

        for(int i = 0; i < N; i++) {
            int num = convertToInt(str.charAt(i));
            answer = (answer + ((long)num * pow)) % 1234567891;

            pow = (pow * 31) % 1234567891;
        }
        System.out.println(answer);
    }

    private static int convertToInt(char a) {
        return a - 'a' + 1;
    }
}