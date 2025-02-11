import java.util.*;
import java.io.*;

class Main {
    static List<Integer>[] friends;
    static boolean[] visited;
    static int N;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            DFS(i, 1);
            if(flag) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static void DFS(int x, int count) {
        if(count == 5) {
            flag = true;
            return;
        }
        visited[x] = true;
        for(int i : friends[x]){
            if(!visited[i]) {
                DFS(i, count + 1);
            }
        }
        visited[x] = false;
    }
}