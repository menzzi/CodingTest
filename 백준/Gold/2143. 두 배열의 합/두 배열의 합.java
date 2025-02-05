import java.util.*;
import java.io.*;

class Main {
    static Long targetNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        targetNum = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        long[] numbersA = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            numbersA[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long[] numbersB = new long[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            numbersB[i] = Long.parseLong(st.nextToken());
        }

        List<Long> subA = findSub(numbersA);
        List<Long> subB = findSub(numbersB);

        Collections.sort(subA);
        Collections.sort(subB, Comparator.reverseOrder());

        long result = 0;
        int ptA = 0;
        int ptB = 0;
        while(true) {
            long currentA = subA.get(ptA);
            long target = targetNum - currentA;

            if(target == subB.get(ptB)) {
                long countA = 0;
                long countB = 0;
                while(ptA < subA.size() && subA.get(ptA) == currentA) {
                    countA++;
                    ptA++;
                }
                while(ptB < subB.size() && subB.get(ptB) == target) {
                    countB++;
                    ptB++;
                }
                result += countA * countB;
            } else if (subB.get(ptB) > target) {
                ptB++;
            } else {
                ptA++;
            }

            if(ptA == subA.size() || ptB == subB.size()) break;
        }
        System.out.println(result);
    }

    private static List<Long> findSub(long[] numbers) {
        List<Long> sub = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            long sum = numbers[i];
            sub.add(sum);
            for(int j = i + 1; j < numbers.length; j++) {
                sum += numbers[j];
                sub.add(sum);
            }
        }
        return sub;
    }
}