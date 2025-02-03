import java.util.*;
import java.io.*;

class Main {
    static boolean[] visited;
    static int N;
    static int[] numbers;
    static int[] symbols;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        symbols = new int[N-1];
        visited = new boolean[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int index = 0;
        for(int i = 0; i < 4; i++) {
            int count = Integer.parseInt(st.nextToken());
            while(count > 0) {
                symbols[index] = i;
                index++;
                count--;
            }
        }

        DFS(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }
    private static void DFS(int depth, int sum) {
        if(depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < N-1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int cal = calculate(symbols[i], sum, numbers[depth]);
                DFS(depth + 1, cal);
                visited[i] = false;
            }
        }
    }

    private static int calculate(int symbol, int sum, int number) {
        if(symbol == 0) {
            return sum + number;
        } else if(symbol == 1) {
            return sum - number;
        } else if (symbol == 2) {
            return sum * number;
        } else{
            if(sum < 0) {
                sum *= -1;
                int result = sum / number;
                return result * -1;
            }
            return sum / number;
        }
    }
}