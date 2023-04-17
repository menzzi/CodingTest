import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.print("<");
        for(int i=1;i<=N;i++){
            q.offer(i);
        }
        while(q.size()!=1){
            for(int i=0;i<K-1;i++){
                q.offer(q.poll());
            }
            System.out.print(q.poll()+", ");
        }
        System.out.println(q.poll()+">");

    }

}


