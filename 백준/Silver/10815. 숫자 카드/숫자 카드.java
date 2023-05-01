import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    static  int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());

            if(binary(num))System.out.print("1 ");
            else System.out.print("0 ");
        }
        br.close();
    }
    static boolean binary(int num){
        int left = 0;
        int right = N-1;

        while(left<=right){
            int midIndex = (left + right) / 2;
            int mid = arr[midIndex];

            if(num>mid)left = midIndex + 1;
            else if(num<mid)right = midIndex - 1;
            else return true;
        }
        return false;
    }
}