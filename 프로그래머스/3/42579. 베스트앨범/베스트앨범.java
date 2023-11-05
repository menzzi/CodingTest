import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String,Integer> genre = new HashMap();
        for(int i=0;i<genres.length;i++){
            genre.put(genres[i],genre.getOrDefault(genres[i],0)+plays[i]);
        }
        ArrayList<String> mapToGenre = new ArrayList<>();
        for(String item : genre.keySet()){
            mapToGenre.add(item);
        }
        mapToGenre.sort((o1,o2)-> genre.get(o2)-genre.get(o1));
        
        ArrayList<Integer> idx = new ArrayList<>();
        for(int i=0;i<mapToGenre.size();i++){
            String g = mapToGenre.get(i);
            
            int max=0;
            int firstIdx = -1;
            for(int j=0;j<genres.length;j++){
                if(g.equals(genres[j]) && max < plays[j]){
                    max = plays[j];
                    firstIdx = j;
                }
            }
            
            max=0;
            int secondIdx = -1;
            for(int j=0;j<genres.length;j++){
                if(g.equals(genres[j]) && max < plays[j] && j!=firstIdx){
                    max = plays[j];
                    secondIdx = j;
                }
            }
            
            idx.add(firstIdx);
            if(secondIdx>=0) idx.add(secondIdx);
            
        }
        
        answer = new int[idx.size()];
        for(int i=0;i<idx.size();i++){
                answer[i] = idx.get(i);
        }
        
        return answer;
    }
}