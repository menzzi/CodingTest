import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];

        if(N >= K) {
            System.out.println(N - K);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;
        int answer = -1;
        while(!queue.isEmpty()) {
            int index = queue.poll();
            if(index == K) {
                System.out.println(visited[index] - 1);
                return;
            }
            if(index - 1 >= 0 && visited[index - 1] == 0) {
                visited[index - 1] = visited[index] + 1;
                queue.add(index - 1);
            }
            if(index + 1 <= 100000 && visited[index + 1] == 0) {
                visited[index + 1] = visited[index] + 1;
                queue.add(index + 1);
            }
            if(index * 2 <= 100000 && visited[index * 2] == 0) {
                visited[index * 2] = visited[index] + 1;
                queue.add(index * 2);
            }
        }

        System.out.println(answer);
    }
}