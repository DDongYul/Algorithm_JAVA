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
                    sb.append(board[i][j]);
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
            List<Integer> list = check(x,y);
            for(Integer i : list){
                board[x][y] = i;
                sol(depth+1,nx,ny);
                board[x][y] = 0;
            }
        }
    }

    //해당 점을 채울 수 있는 체크, 채울 수 있으면 채울 수 있는 수 반환
    private static List<Integer> check(int x, int y) {
        boolean[] arr = new boolean[9];
        //가로, 세로 체크
        for (int i = 0; i < 9; i++) {
            if (board[x][i] != 0) {
                arr[board[x][i] - 1] = true;
            }
            if (board[i][y] != 0) {
                arr[board[i][y] - 1] = true;
            }
        }
        //네모 체크
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if(board[i][j]!=0){
                    arr[board[i][j]-1] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<9; i++){
            if(!arr[i]){
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = str.charAt(j) - '0';
                board[i][j] = num;
            }
        }

        sol(0,0,0);

    }
}