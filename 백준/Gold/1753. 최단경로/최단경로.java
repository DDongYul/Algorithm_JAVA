import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int end;
		int cost;

		public Edge(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		List<Edge>[] edges = new List[V+1];
		for(int i = 1; i<=V; i++) {
			edges[i] = new ArrayList<Edge>();
		}
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[s].add(new Edge(e,c));			
		}
		
		int[] dist = new int[V+1];
		int INF = Integer.MAX_VALUE;
		for(int i = 0; i<=V; i++) {
			dist[i] = INF;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(K,0));
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			int end = curr.end;
			int cost = curr.cost;
			if(dist[end]<cost) {
				continue;
			}
			else {
				dist[end] = cost;
				for (Edge edge : edges[end]) {
					//if문 추가 해주기
					if(dist[edge.end]>cost+edge.cost) {
						dist[edge.end] = cost+edge.cost;
						pq.add(new Edge(edge.end,cost+edge.cost));
					}
				}
			}
		}
		for(int i = 1; i<=V; i++) {
			if(dist[i] == INF) {
				sb.append("INF");
			}
			else {
				sb.append(dist[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}