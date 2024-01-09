import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> genre = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            genre.put(genres[i],genre.getOrDefault(genres[i],0)+plays[i]);
        }
        List<String> keySet = new ArrayList<>(genre.keySet());
        
        keySet.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return genre.get(o2).compareTo(genre.get(o1));
            }
        });
        Queue<Integer> q = new LinkedList<>();
        for(String key:keySet){
            int max1 = 0;
            int num1 = 0;
            for(int i=0;i<genres.length;i++){
                if(genres[i].equals(key)){
                    if(plays[i]>max1){
                        max1 = plays[i];
                        num1 = i;
                    }
                }
            }
            q.offer(num1);
            int max2 = 0;
            int num2 = -1;
            for(int i=0;i<genres.length;i++){
                if(genres[i].equals(key)){
                    if(plays[i]>max2 && i != num1){
                        max2 = plays[i];
                        num2 = i;
                    }
                }
            }
            if(num2 != -1)q.offer(num2);
        }
        int[] answer = new int[q.size()];
        int i=0;
        while(!q.isEmpty()){
            answer[i] = q.poll();
            i+=1;
        }

        return answer;
    }
}