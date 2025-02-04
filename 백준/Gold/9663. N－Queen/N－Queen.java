import java.util.*;
import java.io.*;

class Main {
    static int[] map;
    static int N;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        DFS(0);
        System.out.println(count);
    }

    private static void DFS(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i = 0; i < N; i++) {
            map[depth] = i;
            if(isPossible(depth)) {
                DFS(depth+1);
            }
        }
    }

    private static boolean isPossible(int col) {
        for(int i = 0; i < col; i++) {
            if(map[i] == map[col]) return false;
            if(Math.abs(col - i) == Math.abs(map[col] - map[i])) return false;
        }
        return true;
    }
}