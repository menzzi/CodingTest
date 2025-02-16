import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] parent;
    static List<int[]> parties;
    static List<Integer> knowTheTruth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parties = new ArrayList<>();
        knowTheTruth = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
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

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            arr[0] = Integer.parseInt(st.nextToken());
            for(int j = 1; j < num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                union(arr[0], arr[j]);
            }
            parties.add(arr);
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            int[] party = parties.get(i);
            boolean flag = true;
            for(int num : party) {
                if(knowTheTruth.contains(find(parent[num]))) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        System.out.println(count);
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