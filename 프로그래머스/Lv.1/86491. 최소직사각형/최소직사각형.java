class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]<sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        int max1 = 0,max2 = 0;
        for(int i=0;i<sizes.length;i++){
            if(max1<sizes[i][0])max1 = sizes[i][0];
            if(max2<sizes[i][1])max2 = sizes[i][1];
        }
        answer = max1*max2;
        return answer;
    }
}