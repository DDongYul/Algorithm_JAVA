import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int val;
		
		public Node(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(Node o) {
			return this.val - o.val;
		}
		
		
	}
	
	static int N;
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	private static int dijkstra() {
		int[][] dist = new int[N][N];
		for(int i = 0; i<N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = arr[0][0];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0,arr[0][0]));
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int x = curr.x;
			int y = curr.y;
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(dist[nx][ny]>dist[x][y]+arr[nx][ny]) {
						dist[nx][ny] = dist[x][y]+arr[nx][ny];
						pq.add(new Node(nx,ny,dist[nx][ny]));
					}
				}
			}	
		}

		return dist[N-1][N-1];
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) {
				break;
			}
			arr = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem ").append(t++).append(": ").append(dijkstra()).append("\n");
		}
		System.out.println(sb);
	}
	
}