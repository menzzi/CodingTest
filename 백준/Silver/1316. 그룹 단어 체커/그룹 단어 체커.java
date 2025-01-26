import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean flag = true;
            for(int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                int k = j + 1;
                while( k < str.length() && ch == str.charAt(k)) {
                    k++;
                }
                String newStr = str.substring(k);
                if(newStr.contains(String.valueOf(ch))) {
                    flag = false;
                    break;
                }
                j = k - 1;
            }
            if(flag) answer++;
        }

        System.out.println(answer);
    }
}