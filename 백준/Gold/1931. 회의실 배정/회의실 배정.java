import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new int[]{a,b});
        }
        list.sort((o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int cnt = 0;
        int endTime = 0;
        for(int i = 0; i < N; i++) {
            if(endTime <= list.get(i)[0]) {
                endTime =  list.get(i)[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}