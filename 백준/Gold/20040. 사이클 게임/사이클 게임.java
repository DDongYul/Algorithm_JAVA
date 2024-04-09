import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int parent[];
	
	private static int find(int x) {
		while(x != parent[x]) {
			x = parent[x];
		}
		return x;
	}
	
	private static void union(int x, int y) {
		if(x>y) {
			int temp = x;
			x = y;
			y = temp;
		}
		int xx = find(x);
		int yy = find(y);
		parent[yy] = xx;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i = 1; i<=N; i++) {
			parent[i] = i;
		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(find(x) == find(y)) {
				System.out.println(i);
				System.exit(0);
			}
			union(x,y);
		}
		System.out.println(0);
		//싸이클 여부 -> 이으려는 두 점의 부모가 같으면 cycle 발생
	}
}