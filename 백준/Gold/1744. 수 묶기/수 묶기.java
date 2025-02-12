import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minusNums= new PriorityQueue<>();
        PriorityQueue<Integer> plusNums= new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number >= 0) {
                plusNums.add(number);
            }else {
                minusNums.add(number);
            }
        }

        int sum = 0;
        while(minusNums.size() > 1) {
            int num1 = minusNums.poll();
            if(minusNums.isEmpty()) {
                minusNums.add(num1);
                break;
            }
            sum += (num1 * minusNums.poll());
        }

        while(plusNums.size() > 1 && plusNums.peek() >= 1) {
            int num1 = plusNums.poll();
            if(plusNums.isEmpty() || plusNums.peek() == 0) {
                sum += num1;
                break;
            }
            
            int num2 = plusNums.poll();
            if(num2 == 1) {
                sum += (num1 + num2);
                break;
            } else{
                sum += (num1 * num2);
            }
        }

        if(minusNums.size() == 1) {
            if (plusNums.contains(0)) {
                minusNums.poll();
            } else {
                sum += minusNums.poll();
            }
        }
        
        while(!plusNums.isEmpty()) {
            sum += plusNums.poll();
        }

        System.out.println(sum);
    }
}