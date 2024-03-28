import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;

    private static void sol(int depth, int x, int y){
        if(depth>81){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        int nx = (y+1>8) ? x+1 : x;
        nx = (nx>8) ? 8 : nx;
        int ny = (y+1>8) ? 0 : y+1;
        ny = (ny>8) ? 8 : ny;

        if(board[x][y] !=0){
            sol(depth+1,nx,ny);
        }
        else{
            for(int i = 1; i<=9; i++) {
            	if(check(x, y, i)) {
            		board[x][y] = i;
            		sol(depth+1,nx,ny);
            		board[x][y] = 0;
            	}
            }
        }
    }

    //해당 점을 채울 수 있는 체크, 채울 수 있으면 채울 수 있는 수 반환
    private static boolean check(int x, int y, int val) {
        //가로, 세로 체크
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == val) {
                return false;
            }
            if (board[i][y] == val) {
            	return false;
            }
        }
        //네모 체크
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if(board[i][j]==val){
                	return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        sol(0,0,0);

    }
}