import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        List<Integer> order = new ArrayList<>(map.keySet());
        order.sort((a,b) -> (map.get(b) - map.get(a)));

        for(int key : order) {
            for(int i = 0; i < map.get(key); i++) {
                System.out.print(key + " ");
            }
        }
    }
}