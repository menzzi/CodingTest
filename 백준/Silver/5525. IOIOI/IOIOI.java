import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int answer = 0;
        int count = 0;
        for(int i = 0; i < M-2; i++) {
            if(s.charAt(i) == 'I' && s.charAt(i+1) == 'O' && s.charAt(i+2) == 'I') {
                count++;
                i++;

                if(count == N) {
                    answer++;
                    count--;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(answer);
    }
}