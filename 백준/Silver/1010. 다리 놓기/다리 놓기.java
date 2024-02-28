import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            long[][] DP = new long[N+1][N+1];
            //i:N j:C
            for (int i = 1; i <= N; i++) {
                DP[i][0] = 1;
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <=N ; j++) {
                    if(j>i){
                        continue;
                    }
                    else if(i == j){
                        DP[i][j] = 1;
                    }
                    else{
                        DP[i][j] = DP[i-1][j] + DP[i-1][j-1];
                    }
                }
            }
            sb.append(DP[N][C]).append("\n");
        }
        System.out.println(sb);
    }

}