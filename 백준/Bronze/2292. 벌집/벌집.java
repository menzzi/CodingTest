import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int index = 0;
        int sum = 1;
        while(true) {
            sum += 6 * index;
            if( N <= sum) {
                System.out.println(index + 1);
                return;
            }
            index ++;
        }
    }
}