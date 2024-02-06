import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = -1;
			for(int i = 0; i<N; i++) {
				for(int j = i+1; j<N; j++) {
					int temp = arr[i];
					if(temp+arr[j]<=M) {
						max = Math.max(max, temp+arr[j]);
					}
				}
			}	
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		
	}
}