import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for(int i = 0; i < number; i++) {
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer,Integer> map = new HashMap<>();
            int queueSize = 0;
            int num = Integer.parseInt(br.readLine());

            for(int j = 0; j < num; j++) {
                String[] str = br.readLine().split(" ");
                if(str[0].equals("I")) {
                    int input = Integer.parseInt(str[1]);
                    minQueue.add(input);
                    maxQueue.add(input);
                    queueSize++;
                    map.put(input, map.getOrDefault(input,0) + 1);
                } else {
                    if(queueSize == 0) continue;
                    if(str[1].equals("1")) {
                        delete(maxQueue, map);
                        queueSize--;
                    } else {
                        delete(minQueue, map);
                        queueSize--;
                    }
                }
            }

            if(queueSize == 0) {
                System.out.println("EMPTY");
            } else {
                int max = delete(maxQueue, map);
                int min = max;
                if(queueSize > 1){
                    min = delete(minQueue, map);
                } 
                System.out.printf("%d %d\n", max, min);
            }
        }
    }
    private static int delete(PriorityQueue<Integer> queue, HashMap<Integer, Integer> map) {
        int result = 0;
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            int cnt = map.getOrDefault(poll,0);
            if(cnt == 0) continue;
            if(cnt == 1) map.remove(poll);
            else map.put(poll, cnt - 1);
            result = poll;
            break;
        }
        return result;
    }
}