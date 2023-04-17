import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<int[]> q = new LinkedList<>();

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            boolean check=false;

            StringTokenizer str = new StringTokenizer(br.readLine());

            for(int j=0;j<n;j++){
                q.add(new int[]{j,Integer.parseInt(str.nextToken())});
            }
            while(!q.isEmpty()){
                check = true;
                int[] temp = q.poll();
                for(int j=0;j<q.size();j++){
                    if(temp[1]<q.get(j)[1]){
                        q.offer(temp);
                        for(int k=0;k<j;k++){
                            q.offer(q.poll());
                        }
                        check = false;
                        break;
                    }
                }
                if(check == false) continue;
                count++;
                if(temp[0]==m)break;
            }
            System.out.println(count);
        }


    }

}
