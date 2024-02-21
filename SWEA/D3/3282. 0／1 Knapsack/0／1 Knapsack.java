import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb.append("#").append(t+1).append(" ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            List<int[]> lst = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                lst.add(new int[] {a,b});
            }

            int[][] dp = new int[N+1][K+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <=K ; j++) {
                    if(lst.get(i-1)[0] <= j){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-lst.get(i-1)[0]] + lst.get(i-1)[1]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            sb.append(dp[N][K]).append("\n");
        }
        System.out.println(sb);
    }

}