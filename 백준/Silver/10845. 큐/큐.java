import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int back=0;


        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch(str){
                case "push":
                    back = Integer.parseInt(st.nextToken());
                    q.offer(back);
                    break;
                case "pop":
                    if(q.isEmpty())System.out.println("-1");
                    else System.out.println(q.poll());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if(q.isEmpty())System.out.println("1");
                    else System.out.println("0");
                    break;
                case "front":
                    if(q.isEmpty())System.out.println("-1");
                    else System.out.println(q.peek());
                    break;
                case "back":
                    if(q.isEmpty())System.out.println("-1");
                    else System.out.println(back);
                    break;
            }
        }
    }

}
