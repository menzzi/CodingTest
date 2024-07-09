```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        int[] parent = new int[n];
        long[] num = new long[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            num[i] = 1;
        }
        for(int i=0;i<astronaut.size();i++){
            int parentA = findPar(astronaut.get(i).get(0),parent);
            int parentB = findPar(astronaut.get(i).get(1),parent);
            if(parentA!=parentB){
                union(parentA,parentB,parent,num);
            }
        }
        long total = 0;
        long prv = -1;
        for(int i=0;i<parent.length;i++){
            if(i==parent[i]){
                if(prv==-1)prv = num[i];
                else{
                    total += prv * num[i];
                    prv+=num[i];
                }
            }
        }
        return total;
    }
        
        static int findPar(int p, int[] parent){
            if(p==parent[p])return p;
            return parent[p] = findPar(parent[p],parent);
        }
        static void union(int a,int b,int[] parent,long[] num){
            if(num[a]<=num[b]){
                parent[a] = b;
                num[b] += num[a];
            }else{
                parent[b] = a;
                num[a] += num[b];
            }
        }

    }



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

🚨 런타임 에러 발생
엉엉,, Roads and Libraries 문제처럼 DFS 사용해서 풀려고 했지만 런타임 에러가 났다..!
-> 부모가 같으면 같은 그룹으로 취급해서 해결.

성공 !! 다만.. 한 테스트를 성공 못했는데 int -> long 으로 바꾸니까 됐다.
흠 앞으로는 애초부터 넉넉하게 범위 잡고 시작해야겠다.
스켈레톤 코드의 범위대로 하지말고 수정할 것 ~~~
