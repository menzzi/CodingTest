import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(minheap.size()==0)System.out.println("0");
                else System.out.println(minheap.poll());
            }else{
                minheap.add(num);
            }
        }
    }
}