import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str1 = br.readLine();
        String str2 = br.readLine();

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        int answer = dp[n][m];
        int cnt = answer;

        int i = n;
        int j = m;
        while (cnt>0){
            if(i>0 && j>0) {
                if(dp[i-1][j]==dp[i][j]){
                    i-=1;
                }
                else if(dp[i][j-1]==dp[i][j]){
                    j-=1;
                }
                else{
                    sb.append(str1.charAt(i-1));
                    i-=1;
                    j-=1;
                }
            }
            else{
                break;
            }
        }
        System.out.println(answer);
        System.out.println(sb.reverse());
    }
}