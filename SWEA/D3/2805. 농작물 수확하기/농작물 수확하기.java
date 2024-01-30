import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		//1,3,5,7,5,3,1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr= new int[N][N];
			for(int i = 0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(str.substring(j,j+1));
				}
			}
			int answer = 0;
			int center = N/2;
			
			for(int i = 0; i<center; i++) {
				answer+=arr[i][center];
				answer+=arr[N-i-1][center];
				for(int j = 1; j<i+1; j++) {
					answer+=arr[i][center-j];
					answer+=arr[i][center+j];
					answer+=arr[N-i-1][center-j];
					answer+=arr[N-i-1][center+j];
				}
			}
			for(int i = 0; i<N; i++) {
				answer+=arr[center][i];
			}
			StringBuilder sb = new StringBuilder("#").append(t+1).append(" ").append(answer);
			System.out.println(sb);
		}
		
		
	}
}