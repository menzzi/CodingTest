import java.util.*;
import java.io.*;

class Main {
    static boolean[] visited;
    static int n, answer = 0;
    static ArrayList<int[]>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            tree[from].add(new int[] {to, value});
            tree[to].add(new int[] {from, value});
        }

        for(int i = 1; i <= n; i++){
            visited = new boolean[n + 1];
            visited[i] = true;
            DFS(i, 0);
        }

        System.out.println(answer);
    }

    private static void DFS(int index, int sum) {
        visited[index] = true;
        answer = Math.max(sum, answer);

        for(int[] node : tree[index]) {
            if(!visited[node[0]]) {
                DFS(node[0], sum + node[1]);
            }
        }
    }
}