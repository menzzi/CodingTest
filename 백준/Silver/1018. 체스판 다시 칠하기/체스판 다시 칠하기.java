import java.util.*;
import java.io.*;

class Main {
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new String[N][M];

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = str[j];
            }
        }

        System.out.println(find(N,M));
    }

    private static int find(int N, int M) {
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < N - 7; i++) {
            for(int j = 0; j < M - 7; j++) {
                int cnt1 = 0;
                int cnt2 = 0;
                for(int n = i; n < i + 8; n += 2) {
                    for(int m = j; m < j + 8; m += 2) {
                        if(map[n][m].equals("W")) cnt2++;
                        else cnt1++;
                        if(map[n + 1][m + 1].equals("W")) cnt2++;
                        else cnt1++;
                        if(map[n][m + 1].equals("B")) cnt2++;
                        else cnt1++;
                        if(map[n + 1][m].equals("B")) cnt2++;
                        else cnt1++;
                    }
                }
                answer = Math.min(answer, Math.min(cnt1, cnt2));

            }
        }
        return answer;
    }
}