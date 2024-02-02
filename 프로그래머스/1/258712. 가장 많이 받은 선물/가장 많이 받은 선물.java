import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<>();
        int[] degree = new int[friends.length];
        int[][] graph = new int[friends.length][friends.length];
        
        for(int i=0;i<friends.length;i++){
            map.put(friends[i],i);
        }
        for(int i=0;i<gifts.length;i++){
            String[] name = gifts[i].split(" ");
            degree[map.get(name[0])]++;
            degree[map.get(name[1])]--;
            graph[map.get(name[0])][map.get(name[1])]++;
        }
        for(int i=0;i<friends.length;i++){
            int num = 0;
            for(int j=0;j<friends.length;j++){
                if(i==j)continue;
                if(graph[i][j]>graph[j][i] || (graph[i][j]==graph[j][i] && degree[i]>degree[j])){
                    num++;
                }
            }
            answer = Math.max(answer,num);
        }
        return answer;
    }
}