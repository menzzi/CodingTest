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
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */
    public static int[][] graph;
    public static int[] parent;
    public static int total;
    
    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        total = 0;
        parent = new int[gNodes+1];
        graph = new int[gFrom.size()][3];
        for(int i=0;i<gFrom.size();i++){
            graph[i][0] = gFrom.get(i);
            graph[i][1] = gTo.get(i);
            graph[i][2] = gWeight.get(i);
        }
        for(int i=1;i<=gNodes;i++){
            parent[i] = i;
        }
        Arrays.sort(graph,(o1,o2)->Integer.compare(o1[2],o2[2]));
        
        for(int i=0;i<gFrom.size();i++){
            if(findPar(graph[i][0])!=findPar(graph[i][1])){
                union(graph[i][0],graph[i][1]);
                total += graph[i][2];
            }
        }
        return total;
    }
    public static int findPar(int p){
        if(p==parent[p])return p;
        return parent[p] = findPar(parent[p]);
    }
    public static void union(int a,int b){
        int pa = findPar(a);
        int pb = findPar(b);
        if(pa != pb) parent[b] = a;
    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


```

- 풀기위해 크루스칼 알고리즘을 다시 한 번 공부했다. ㅎㅎ  
🚨 런타임 에러 => 1) 하핫 그래프의 범위를 잘못 잡았다.. 노드 수가 아닌 엣지 수로 잡아야 한다!  
 
 2) 그리구,,, 메인 코드에서 수정을 해야한다는 것을 못 봤다.  
 3) 다음과 같이 고치니 다 맞았다.  
    ```java
    public static void union(int a,int b){
        int pa = findPar(a);
        int pb = findPar(b);
        if(pa != pb) parent[b] = a;
    }
    ```
    -> 바꾼 코드
    ```java
    public static void union(int a,int b){
        if(a < b)parent[b] = a;        
        else parent[a] = b;
    }
    ```
    -> 바꾸기 전 코드
    왜 그랬징,,,
