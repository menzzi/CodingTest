import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder str = new StringBuilder();

        DFS(0, str);
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth, StringBuilder str) throws IOException {
        if(depth == M) {
            bw.write(str.toString().trim() + "\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            str.append(i).append(" ");
            DFS(depth + 1, str);
            str.setLength(str.length() - 2);
        }
    }
}