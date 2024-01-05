import java.util.*;
class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs,(int[] c1,int[] c2)-> c1[2]-c2[2]);
        
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        for(int i=0;i<costs.length;i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            
            int fromParent = findParent(from);
            int toParent = findParent(to);
            
            if(fromParent == toParent) continue;
            
            answer +=cost;
            parent[toParent] = fromParent;
        }
        return answer;
    }
    
    public int findParent(int child){
        if(parent[child]==child)return parent[child];
        return parent[child] = findParent(parent[child]);
    }
}