import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static boolean[] visited;
    static String[] strings;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K < 5) {
            System.out.println("0");
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        strings = new String[N];
        for(int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        solve(5, 1);
        System.out.println(max);
    }

    private static void solve(int depth, int index) {
        if(depth == K) {
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                String str = strings[i];
                cnt++;
                for(int j = 4; j < str.length() - 4; j++) {
                    if(!visited[str.charAt(j) - 'a']) {
                        cnt--;
                        break;
                    }
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        for(int i = index; i < 26; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                solve(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}