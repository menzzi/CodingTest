import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int T = Integer.parseInt(br.readLine());

       for(int i=0;i<T;i++){
           HashSet<Integer> set = new HashSet<>();
           int n = Integer.parseInt(br.readLine());
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j=0;j<n;j++){
               int num = Integer.parseInt(st.nextToken());
               set.add(num);
           }
           int m = Integer.parseInt(br.readLine());
           st = new StringTokenizer(br.readLine());
           for(int j=0;j<m;j++){
               int num2 = Integer.parseInt(st.nextToken());
               if(set.contains(num2)){
                   bw.write("1\n");
               }else bw.write("0\n");
           }
       }
        bw.flush();
    }
}