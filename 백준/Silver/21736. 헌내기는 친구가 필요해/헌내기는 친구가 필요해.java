import java.io.IOException;
import java.util.Scanner;

public class Main{

    static char[][] ground;
    static boolean[][] check;
    static int N,M;
    static int count;
    static int result=0;

    static void dfs(int starti,int startj) {

        check[starti][startj] = true;

        int[] X = {-1,0,+1,0};
        int[] Y = {0,-1,0,+1};

        for(int i=0;i<4;i++) {

            int x = starti+X[i];
            int y = startj+Y[i];

            if(x<0||x>=N||y<0||y>=M||check[x][y])continue;

            if(ground[x][y]=='O') {
                check[x][y] = true;
                dfs(x,y);
            }else if(ground[x][y]=='X') {
                check[x][y] = true;
                continue;
            }else if(ground[x][y]=='P') {
                check[x][y] = true;
                dfs(x,y);
                count++;
            }

        }
    }


    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        int starti=0,startj=0;

        N = scan.nextInt();
        M = scan.nextInt();

        ground = new char[N][M];
        check = new boolean[N][M];

        for(int i=0;i<N;i++) {
            String str = scan.next();
            for(int j=0;j<M;j++) {
                ground[i][j] = str.charAt(j);
                if(ground[i][j]=='I') {
                    starti = i;
                    startj = j;
                }
            }
        }

        dfs(starti,startj);

        if(count==0) {
            System.out.println("TT");
        }else {
            System.out.println(count);
        }
    }

}

