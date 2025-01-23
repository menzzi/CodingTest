import java.util.*;
import java.io.*;

class Main {
    static ArrayList<int[]>[] tree;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        tree = new ArrayList[N+1];
        for(int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

         for(int i = 0; i < N-1; i++) {
            String[] str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int value = Integer.parseInt(str[2]);

            tree[from].add(new int[]{to, value});
            tree[to].add(new int[]{from, value});
         }

         for(int i = 0; i < M; i++) {
             String[] str = br.readLine().split(" ");
             int from = Integer.parseInt(str[0]);
             int to = Integer.parseInt(str[1]);

             visited = new boolean[N + 1];
             int answer = DFS(from, to,0);
             System.out.println(answer);
         }
    }
    private static int DFS(int from, int to, int sum) {
        if(from == to) return sum;

        visited[from] = true;

        for(int[] node : tree[from]) {
            if(!visited[node[0]]) {
                int result = DFS(node[0], to, sum + node[1]);
                if(result != -1)return result;
            }
        }
        return -1;
    }
}