import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N+1];
		for(int i = 1; i<=N; i++) {
			DP[i] = 1000000;
		}
		DP[1] = 0;
		for(int i = 1; i<N; i++) {
			if(i*3<=N) {
				DP[i*3] = Math.min(DP[i*3], DP[i]+1);
			}
			if(i*2<=N) {
				DP[i*2] = Math.min(DP[i*2], DP[i]+1);
			}
			
			DP[i+1] = Math.min(DP[i+1], DP[i]+1);
		}
		System.out.println(DP[N]);
	}
}