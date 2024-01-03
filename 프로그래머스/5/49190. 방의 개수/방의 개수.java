import java.util.*;

class Solution {
    static class Pair{
        public int x;
        public int y;
        
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
        
        public int hashCode(){
            return Objects.hash(x,y);
        }
        public boolean equals(Object o){
            return this.x == ((Pair) o).x && this.y == ((Pair) o).y;
        }
    }
    
    public int solution(int[] arrows) {
        int answer = 0;
        
        Pair point = new Pair(0,0);
        int[] dx = {0,1,1,1,0,-1,-1,-1};
        int[] dy = {1,1,0,-1,-1,-1,0,1};
        
        HashMap<Pair,ArrayList<Pair>> visited = new HashMap<>();
        
        for(int i=0;i<arrows.length;i++){
            for(int j=0;j<=1;j++){
                
                Pair newpoint = new Pair(point.x + dx[arrows[i]],point.y+ dy[arrows[i]]);
                
                if(!visited.containsKey(newpoint)){
                    visited.put(newpoint,newedge(point));
                    
                    if(visited.get(point) == null){
                        visited.put(point,newedge(newpoint));
                    }else{
                        visited.get(point).add(newpoint);
                    }
                }else if(visited.containsKey(newpoint) && !(visited.get(newpoint).contains(point))){
                    visited.get(newpoint).add(point);
                    visited.get(point).add(newpoint);
                    answer+=1;
                }
                point = newpoint;
            }
        }
        return answer;
    }
    
    public static ArrayList<Pair> newedge(Pair point){
        ArrayList<Pair> edge = new ArrayList<>();
        edge.add(point);
        return edge;
    }
}