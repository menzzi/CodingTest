import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int back = 0;

        while(n>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    back = num;
                    q.add(num);
                    break;
                case "pop":
                    if(q.isEmpty())sb.append(-1).append('\n');
                    else sb.append(q.poll()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    if(q.isEmpty())sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(q.isEmpty())sb.append(-1).append('\n');
                    else sb.append(q.peek()).append('\n');
                    break;
                case "back":
                    if(q.isEmpty())sb.append(-1).append('\n');
                    else sb.append(back).append('\n');
                    break;
            }
            n--;
        }
        System.out.print(sb);
    }
}