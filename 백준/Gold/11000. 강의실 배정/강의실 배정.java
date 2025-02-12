import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> lessonTime = new PriorityQueue<>();
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }
        Collections.sort(list, (a,b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        lessonTime.add(list.get(0)[1]);
        for(int i = 1; i < N; i++) {
            int start = list.get(i)[0];
            if(start >= lessonTime.peek()) {
                lessonTime.poll();
            }
            lessonTime.add(list.get(i)[1]);
        }

        System.out.println(lessonTime.size());
    }
}