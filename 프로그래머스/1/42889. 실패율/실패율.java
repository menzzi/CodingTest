import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer,Double> map = new HashMap<>();
        int num =1;
        Arrays.sort(stages);
        while(num<=N){
            int p =0;
            int c = 0;
            for(int i=0;i<stages.length;i++){
                if(stages[i]==num) c++;
                if(stages[i]>=num) p++;
            }
            double put = 0.0;
            if (p != 0) {
                put = (double) c / p;
            }
            map.put(num,put);
            num++;
        }
        
        List<Map.Entry<Integer,Double>> li = new ArrayList<>(map.entrySet());
        li.sort(Map.Entry.comparingByValue((Comparator.reverseOrder())));
        int idx = 0;
        for(Map.Entry<Integer,Double> entry : li){
            answer[idx] = entry.getKey();
            idx++;
        }
        return answer;
    }
}