import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int[] newEle = new int[elements.length*2];
        for(int i=0;i<elements.length;i++){
            newEle[i] = newEle[i+elements.length] = elements[i];
        }
        for(int s=1;s<=elements.length;s++){
            for(int i=0;i<elements.length;i++){
                int sum = 0;
                for(int j=i;j<i+s;j++){
                    sum += newEle[j];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}