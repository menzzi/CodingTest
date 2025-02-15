import java.util.*;
import java.io.*;

class Main {
    static boolean[] visited;
    static List<Integer>[] relation;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        relation = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) {
            relation[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int targetP1 = Integer.parseInt(st.nextToken());
        int targetP2 = Integer.parseInt(st.nextToken());

        int relationCount = Integer.parseInt(br.readLine());
        for(int i = 1; i <= relationCount; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            relation[p1].add(p2);
            relation[p2].add(p1);
        }
        DFS(targetP1, targetP2, 0);
        System.out.println(answer);
    }

    private static void DFS(int start, int end, int cnt) {
        if(start == end) {
            answer = cnt;
            return;
        }
        visited[start] = true;

        for(int i = 0; i < relation[start].size(); i++) {
            int next = relation[start].get(i);
            if(!visited[next]) {
                DFS(next, end, cnt + 1);
            }
        }
    }
}