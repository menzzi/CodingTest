import java.util.*;
import java.io.*;

class Main {
    static int answer = 0;
    static ArrayList<int[]>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());

        tree = new ArrayList[nodeCount + 1];

        for(int i = 1; i <= nodeCount; i++) {
            tree[i] = new ArrayList<>();
        }

        String line;
        while((line = br.readLine())!= null) {
            String[] values = line.split(" ");
            int from = Integer.parseInt(values[0]);
            int to = Integer.parseInt(values[1]);
            int value = Integer.parseInt(values[2]);

            tree[from].add(new int[] {to, value});
            tree[to].add(new int[] {from, value});
        }

        for(int i = 1; i<= nodeCount; i++) {
            visited = new boolean[nodeCount + 1];
            visited[i] = true;
            DFS(i, 0);
        }

        System.out.println(answer);
    }
    private static void DFS(int idx, int sum) {
        visited[idx] = true;
        answer = Math.max(answer, sum);

        for(int[] node : tree[idx]) {
            if(!visited[node[0]]) {
                DFS(node[0], sum + node[1]);
            }
        }
    }
}