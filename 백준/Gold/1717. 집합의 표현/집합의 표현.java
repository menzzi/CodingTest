import java.util.*;
import java.io.*;

class Main {
    static int[] parent;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());
            if(number == 0) {
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                union(num1, num2);
            } else if(number == 1) {
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                if(findParent(num1) == findParent(num2)) {
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int num1, int num2) {
        int parent1 = findParent(num1);
        int parent2 = findParent(num2);
        parent[parent2] = parent1;
    }

    private static int findParent(int num) {
        if(num == parent[num]) {
            return num;
        }
        return parent[num] = findParent(parent[num]);
    }
}