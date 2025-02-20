class Solution {
    static char[][] map;
    static int countO = 0;
    static int countX = 0;
    public int solution(String[] board) {
        int answer = 1;
        if(!isCollectCount(board)) return 0;
        
        map = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(map[i][j] != '.') {
                    if(isWin(i, j)) {
                        if(map[i][j] == 'O') {
                            if(countO == countX) return 0;
                        } else {
                            if(countO > countX) return 0;
                        }
                    }
                }
            }
        }
        return answer;
    }
    private boolean isCollectCount(String[] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'O') {
                    countO++;
                } else if(board[i].charAt(j) == 'X') {
                    countX++;
                }
            }
        }
        if(countO == countX || countO == countX + 1) return true;
        else return false;
    }
    
    private boolean isWin(int x, int y) {
        if(x == y) {
            if(map[0][0] == map[1][1] && map[0][0] == map[2][2]) {
                return true;
            }
        }
        
        if(x == y + 2 || x == y - 2) {
            if(map[x][y] == map[1][1] && map[x][y] == map[y][x]) {
                return true;
            }
        }
        
        if(map[x][0] == map[x][1] && map[x][0] == map[x][2]) {
            return true;
        }
        if(map[0][y] == map[1][y] && map[0][y] == map[2][y]) {
            return true;
        }
        return false;
    }
}