import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        String[] str = skill.split("");
        
        for(int i=0;i<skill_trees.length;i++){
            String[] s = skill_trees[i].split("");
            boolean[] tree = new boolean[str.length];
            boolean check = true;
            for(int j=0;j<s.length;j++){
                for(int k=0;k<str.length;k++){
                    if(s[j].equals(str[k])){
                        for(int l=0;l<k;l++){
                            if(!tree[l]){
                                check = false;
                                answer-=1;
                                break;
                            }
                        }
                        if(!check)break;
                        tree[k] = true;
                    }
                }
                if(!check)break;
            }
        }
        
        return answer;
    }
}