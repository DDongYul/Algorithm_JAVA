import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 3];
		dp[0] = 5000;
		dp[1] = 5000;
		dp[2] = 5000;
		dp[3] = 1;
		dp[4] = 5000;
		dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			
			dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
		}
		if(dp[N] >= 5000) {
			System.out.println(-1);
		}
		else {
		System.out.println(dp[N]);
		}
	}
}