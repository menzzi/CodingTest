import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(maxheap.size()==0)System.out.println("0");
                else System.out.println(maxheap.poll());
            }else{
                maxheap.add(num);
            }
        }
    }
}