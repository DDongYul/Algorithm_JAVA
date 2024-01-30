import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static int[] arr;
	static int[] visited;
	static int N;
	static int M;
	
	static void combination(int depth) {
		if(depth == M) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i<N+1; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				arr[depth] = i;
				combination(depth+1);
				visited[i] = 0;
				arr[depth] = 0;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new int[N+1];
		sb = new StringBuilder();
		combination(0);
		System.out.println(sb);
	}
}