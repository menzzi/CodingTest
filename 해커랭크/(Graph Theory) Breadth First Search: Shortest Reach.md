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

public class Solution {

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int s) {
         LinkedList<Integer> q = new LinkedList<>();
         ArrayList<Integer> ans = new ArrayList<>(adj.size());
         
         for(int i=0;i<adj.size();i++){
             ans.add(0);
         }
         q.add(s);
         while(!q.isEmpty()){
             int cur = q.poll();
             ArrayList<Integer> tmp = adj.get(cur);
             for(int i=0;i<tmp.size();i++){
                 int v = tmp.get(i);
                 if(ans.get(v)==0){
                     q.add(v);
                     ans.set(v,ans.get(cur)+6);
                 }
             }
         }
         return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
       
        for(int i=0;i<q;i++){
            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
            for(int j=0;j<n;j++){
                adj.add(new ArrayList<Integer>());
            }
            int m = in.nextInt();
            for(int j=0;j<m;j++){
                int u = in.nextInt()-1;
                int v = in.nextInt()-1;
                
                ArrayList<Integer> tmp = adj.get(u);
                tmp.add(v);
                adj.set(u,tmp);
                
                tmp = adj.get(v);
                tmp.add(u);
                adj.set(v,tmp);
            }
            int s = in.nextInt()-1;
            ArrayList<Integer> ans = bfs(adj,s);
            
            for(int j=0;j<n;j++){
                if(j==s)continue;
                if(ans.get(j)==0)System.out.print("-1 ");
                else System.out.print(ans.get(j)+" ");
            }
            System.out.println("");
        }
    }
}

```
우선 내가 왜 그랬지... 문제에 떡하니 BFS 사용하라고 했는데 푸는 도중에 까먹고 그냥 풀어서 런타임 에러!  
