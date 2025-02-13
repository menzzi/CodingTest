import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(find(num1) == find(num2)) {
                System.out.println(i + 1);
                return;
            }
            union(num1, num2);

        }

        System.out.println(0);
    }

    private static int find(int x) {
        if(parent[x] == x) {
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }

    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(parentX < parentY) {
            parent[parentY] = parentX;
        } else {
            parent[parentX] = parentY;
        }
    }
}