import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][2];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[K+1];
		for(int i = 0; i<N; i++) {
			int w = arr[i][0];
			int v = arr[i][1];
			for(int j = K; j>=w; j--) {
				dp[j] = Math.max(dp[j], dp[j-w] + v);
			}
		}
		System.out.println(dp[K]);

	}

}