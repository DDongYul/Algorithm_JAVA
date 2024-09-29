import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //0 가로 1 세로 2 대각
        long[][][] dp = new long[N+1][N+1][3];
        dp[1][2][0] = 1;


        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if(board[i][j]==1) continue;

                // 가로 (0)
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                if(i==1) continue; // 맨 윗줄이면 continue

                // 세로 (1)
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if(board[i-1][j]==1 || board[i][j-1]==1) continue;

                // 대각선 (2)
                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }
        long answer = 0;
        for (int i = 0; i < 3; i++) {
            answer+=dp[N][N][i];
        }
        System.out.println(answer);
    }
}