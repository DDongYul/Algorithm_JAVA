import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = board[i][j] + board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
            }
        }

        int max = -1001;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int currI = i+1;
                int currJ = j+1;
                while(currI<=N && currJ<=N){
                    int curr = board[currI][currJ] - (board[i][currJ] + board[currI][j] - board[i][j]);
                    max = Math.max(max, curr);
                    currI++;
                    currJ++;
                }
            }
        }
        System.out.println(max);

    }

}