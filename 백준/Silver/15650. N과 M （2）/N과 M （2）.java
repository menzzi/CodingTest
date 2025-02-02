import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        String str = "";

        DFS(0, str,1);
    }

    private static void DFS(int depth, String str, int index) {
        if(depth == M) {
            System.out.println(str);
        }

        for(int i = index; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(depth + 1, str + i + " ", i+1);
                visited[i] = false;
            }
        }
    }
}