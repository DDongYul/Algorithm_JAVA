import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;
	
	static void combination(int n, int depth) {
		if(M==depth) {
			for (int i : arr) {
				if(i!=0) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		for(int i = n; i<N+1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				combination(i,depth+1);
				visited[i] = false;
				arr[depth] = 0;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		combination(1,0);
		System.out.println(sb);
	}
}