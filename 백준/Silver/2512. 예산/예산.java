import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());

        int left = 0;
        int right = arr[N-1];
        while(left<=right){
            int mid = (left+right)/2;
            int budget = 0;
            for(int i=0;i<N;i++){
                if(arr[i]>mid)budget+=mid;
                else budget+=arr[i];
            }
            if(budget>m)right=mid-1;
            else left = mid+1;

        }
        System.out.println(right);

    }
}