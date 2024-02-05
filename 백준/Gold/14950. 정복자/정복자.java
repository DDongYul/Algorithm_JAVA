import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * prim 알고리즘으로 풀기 각 라운드에서 PQ로 꺼내가며 진행
 *
 */
public class Main {

	static class Node{
		int index;
		List<Edge> edge;

		public Node(int index) {
			this.index = index;
			edge = new ArrayList<Edge>();
		}
	}
	
	static class Edge{
		int end;
		int cost;
		
		public Edge(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		Node[] nodes = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes[s].edge.add(new Edge(e,c));
			nodes[e].edge.add(new Edge(s,c));
		}
		
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.cost - e2.cost;
			}
		});
		
		for (Edge edge : nodes[1].edge) {
			pq.add(edge);
		}
		
		int cnt = 1;
		int answer = 0;
		while(cnt<N) {
			Edge curr = pq.poll();
			if(!visited[curr.end]) {
				for(Edge edge: nodes[curr.end].edge) {
					pq.add(edge);
				}
				answer = answer + (cnt-1)*t + curr.cost;
				visited[curr.end] = true;
				cnt+=1;
			}
		}
		System.out.println(answer);
	}
}