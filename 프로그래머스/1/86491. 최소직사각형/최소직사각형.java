class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        int maxFirst = 0;
        int maxSecond = 0;
        
        for(int[] size : sizes){
            if(maxFirst < size[0]){
                maxFirst = size[0];
            }
            if(maxSecond < size[1]){
                maxSecond = size[1];
            }
        }
        
        answer = maxFirst * maxSecond;
        return answer;
    }
}