import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static List<Integer> knowTheTruth = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int number = Integer.parseInt(st.nextToken());

        if(number == 0) {
            System.out.println(M);
            return;
        }

        for(int i = 0; i < number; i++) {
            knowTheTruth.add(Integer.parseInt(st.nextToken()));
        }

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        List<Integer> [] parties = new ArrayList[M];
        for(int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            parties[i].add(x);
            for(int j = 1; j < num; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x,y);
                parties[i].add(y);
            }
        }

        int cnt = 0;
        for(int i = 0; i < M; i++) {
            boolean flag = true;
            for(int num : parties[i]) {
                if(knowTheTruth.contains(find(parent[num]))){
                    flag = false;break;
                }
            }
            if(flag) cnt++;
        }
        System.out.println(cnt);
    }

    private static int find(int x) {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if(knowTheTruth.contains(parentY)) {
            int tmp = parentX;
            parentX = parentY;
            parentY = tmp;
        }
        parent[parentY] = parentX;
    }
}