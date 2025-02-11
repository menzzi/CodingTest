import java.util.*;
import java.io.*;

class Main {
    static int[][] apples;
    static int[][] map;
    static int N;
    static Map<Integer, String> shifts = new HashMap<>();

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int shift = 1; // 처음은 오른쪽으로 이동
    static Deque<int[]> snake = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        apples = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            apples[x][y] = 2;
        }

        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int second = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            shifts.put(second, str);
        }

        map[1][1] = 1;
        snake.add(new int[]{1,1});

        int currentTime = 0;
        boolean isGoing = true;
        while(isGoing) {
            currentTime++;
            isGoing = move(currentTime);
        }

        System.out.println(currentTime);
    }

    private static boolean move(int currentTime) {
        int[] head = snake.getFirst();
        int[] nextHead =new int[] {head[0] + dx[shift], head[1] + dy[shift]};

        if(isSafe(nextHead)) {
            snake.addFirst(nextHead);
            map[nextHead[0]][nextHead[1]] = 1;
        }else {
            return false;
        }

        if(apples[nextHead[0]][nextHead[1]] == 2) {
            apples[nextHead[0]][nextHead[1]] = 0;
        }else {
            int[] tail = snake.getLast();
            map[tail[0]][tail[1]] = 0;
            snake.removeLast();
        }

        if(shifts.containsKey(currentTime)) {
            if(shifts.get(currentTime).equals("L")) {
                shift++;
                if(shift == 4) {
                    shift = 0;
                }
            } else {
                shift--;
                if(shift == -1) {
                    shift = 3;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[] nextHead) {
        if(nextHead[0] < 1 || nextHead[1] < 1 || nextHead[0] > N || nextHead[1] > N) {
            return false;
        }

        if(map[nextHead[0]][nextHead[1]] == 1) {
            return false;
        }

        return true;
    }
}