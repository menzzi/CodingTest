import java.util.*;
import java.io.*;

class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            StringBuilder str = new StringBuilder();
            List<String> list = new ArrayList<>();

            for(int i = 0; i < k; i++) {
                list.add(st.nextToken());
            }

            DFS(0, str, -1, list);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth, StringBuilder str, int index, List<String> list) throws IOException {
        if(depth == 6) {
            bw.write(str.toString().trim() + "\n");
            return;
        }

        for(int i = index + 1; i < list.size(); i++) {
            int len = str.length();
            str.append(list.get(i)).append(" ");
            DFS(depth + 1, str, i, list);
            str.setLength(len);
        }
    }
}