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
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

   public static boolean[] visited;
   public static ArrayList<Integer> adj[];
   public static long DFS(int cur){
       long ret = 0;
       for(int i=0;i<adj[cur].size();i++){
           int next = adj[cur].get(i);
           if(!visited[next]){
               visited[next] = true;
               ret++;
               ret += DFS(next);
           }
       }
       return ret;
   }
   public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<cities.size();i++){
            int a = cities.get(i).get(0);
            int b = cities.get(i).get(1);
            
            adj[a].add(b);
            adj[b].add(a);
        }
        long cnt = 0;
        long ans = 0;
        for(int i=1;i<=n;i++){
            if(visited[i])continue;
            visited[i] = true;
            cnt++;
            long road_cnt = DFS(i);
            ans += Math.min((road_cnt+1)*c_lib,(c_road*road_cnt)+c_lib);
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

- ICT 코딩테스트를 위해 처음으로 해커랭크를 통해 풀어봤다. 
- 그래프 관련 문제였는데 DFS 사용해서 풀어줬다.
```
