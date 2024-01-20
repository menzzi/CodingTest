import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        Arrays.sort(costs,(int[] c1,int[] c2)->(c1[2]-c2[2]));
        
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int i=0;i<costs.length;i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            
            int fromP = findParent(from);
            int toP = findParent(to);
            
            if(fromP == toP) continue;
            
            parent[toP] = fromP;
            answer += cost;
        }
        
        return answer;
    }
    public int findParent(int child){
        if(parent[child] == child) return parent[child];
        else return parent[child] = findParent(parent[child]);
    }
}