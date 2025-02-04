import java.sql.Array;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            queue1.add(i);
        }

        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            int index = 1;

            while(index <= K) {
                while(!queue1.isEmpty()) {
                    queue2.add(queue1.poll());
                    index++;
                    if(index == K) break;
                }
                while(!queue2.isEmpty()) {
                    queue1.add(queue2.poll());
                    index++;
                    if(index == K) break;
                }
            }

            if(!queue1.isEmpty()) {
                result.add(queue1.poll());
            }
            else if (!queue2.isEmpty()){
                result.add(queue2.poll());
            }
        }

        System.out.print("<");
        for(int i = 0; i < result.size() - 1; i++) {
            System.out.print(result.get(i) + ", ");
        }
        System.out.print(result.get(result.size() - 1));
        System.out.print(">");

    }
}