class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(s<n)return new int[] {-1};
        int idx = 0;
        while(n>0){
            answer[idx]=s/n;
            s-=answer[idx++];
            n--;
        }
        return answer;
    }
}