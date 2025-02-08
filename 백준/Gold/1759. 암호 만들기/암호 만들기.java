import java.util.*;
import java.io.*;

class Main {
    static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static int N, M;
    static String[] alphabets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        alphabets = br.readLine().split(" ");
        Arrays.sort(alphabets);

        StringBuilder sb = new StringBuilder();
        makePW(0, sb, 0);
        br.close();
    }

    private static void makePW(int depth, StringBuilder sb, int index) {
        if(depth == N) {
            if(checkPW(sb.toString())) {
                System.out.println(sb);
            }
            return;
        }

        for(int i = index; i < M; i++) {
            sb.append(alphabets[i]);
            makePW(depth + 1, sb, i + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    private static boolean checkPW(String str) {
        int vowelCnt = 0;
        for(int i = 0; i < str.length(); i++) {
            for(char ch : vowels){
                if(ch == str.charAt(i)) {
                    vowelCnt++;
                    break;
                }
            }
        }
        if(vowelCnt >= 1 && str.length() - vowelCnt >= 2) return true;
        return false;
    }
}