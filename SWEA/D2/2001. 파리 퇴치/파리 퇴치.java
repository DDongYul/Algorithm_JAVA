import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int M;
	static int[][] graph;
	
	static int cal(int x, int y) {
		int cnt = 0;
		for(int i = x; i<x+M; i++) {
			for(int j=y; j<y+M; j++) {
				cnt+=graph[i][j];
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int answer = 0;
			for(int i = 0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					answer = Math.max(answer,cal(i,j));
				}
			}
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);

	}
}