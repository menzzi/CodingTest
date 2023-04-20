import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main{
    static char[][] map;
    static boolean[][] check;
    static int result;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        map = new char[N+1][M+1];
        check = new boolean[N+1][M+1];

        for(int i=0;i<N;i++){
            String str = scan.next();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
            }
        }

        result = 0;
        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '-' && !check[i][j]) {
                    dfs1(i, j);
                    result++;
                } else if (map[i][j] == '|' && !check[i][j]) {
                    dfs2(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    public static void dfs1(int startY, int startX){

        int x[] = {-1,1};

        for(int i=0;i<2;i++){
            int X = startX + 1;
            int Y = startY;

            if(X>=M||check[Y][X])continue;

            if(map[Y][X]==map[startY][startX]){
                check[Y][X] = true;
                dfs1(Y,X);
            }
        }

    }
    public static void dfs2(int startY, int startX){

        int y[] = {-1,1};


        for(int i=0;i<2;i++){
            int X = startX;
            int Y = startY + y[i];

            if(Y<0||Y>=N||check[Y][X])continue;

            if(map[Y][X]==map[startY][startX]){
                check[Y][X] = true;
                dfs2(Y,X);
            }
        }

    }
 }

