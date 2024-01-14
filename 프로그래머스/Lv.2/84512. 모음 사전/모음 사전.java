class Solution {
    public int solution(String word) {
        int answer = word.length();
        String s = "AEIOU";
        int[] n = {781,156,31,6,1};
        for(int i=0;i<word.length();i++){
            int cnt = s.indexOf(word.charAt(i));
            answer+= cnt * n[i];
        }
        return answer;
    }
}