import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T > 0) {
            T--;
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            int queueSize = 0;
            for(int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str1 = st.nextToken();

                if(str1.equals("I")) {
                    int number = Integer.parseInt(st.nextToken());
                    minQ.add(number);
                    maxQ.add(number);
                    map.put(number, map.getOrDefault(number, 0) + 1);
                    queueSize++;
                } else {
                    if(queueSize == 0) continue;
                    String str2 = st.nextToken();
                    if(str2.equals("1")) {
                        delete(maxQ, map);
                        queueSize--;
                    } else {
                        delete(minQ, map);
                        queueSize--;
                    }
                }
            }

            if(queueSize == 0) {
                System.out.println("EMPTY");
            } else {
                int max = delete(maxQ, map);
                int min = max;
                if(queueSize > 1) {
                    min = delete(minQ, map);
                }
                System.out.printf("%d %d\n", max, min);
            }
        }
    }

    private static int delete(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
        int result = 0;
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            int cnt = map.getOrDefault(poll, 0);
            if(cnt == 0) continue;
            if(cnt == 1) map.remove(poll);
            else map.put(poll, cnt - 1);
            result = poll;
            break;
        }
        return result;
    }
}