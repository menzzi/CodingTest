import java.util.*;
import java.io.*;

class Main {
    static PriorityQueue<Integer> left;
    static PriorityQueue<Integer> right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            addNum(number);
            System.out.println(findMed());
        }
    }

    private static void addNum(int number) {
        if(left.isEmpty() || number <= left.peek()) {
            left.add(number);
        } else {
            right.add(number);
        }

        if(left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if(right.size() > left.size()){
            left.add(right.poll());
        }
    }

    private static int findMed() {
        if(left.size() == right.size() + 1) {
            return left.peek();
        } else{
            return Math.min(left.peek(), right.peek());
        }
    }
}