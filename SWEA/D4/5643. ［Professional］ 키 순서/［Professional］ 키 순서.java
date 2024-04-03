import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 큰 방향으로 한 번
 * 작은 방향으로 한 번 
 */
public class Solution {

	static class Node{
		int x;
		int order;
		
		public Node(int x, int order) {
			this.x = x;
			this.order = order;
		}
		
	}
	
	static int N, M;
	static List<Node>[] edge;
	static boolean[][] check;
	
	//order 0 : 나보다 작은 방향, order 1: 나보다 큰 방향
	static void bfs(int start, int order) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.add(start);
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		check[start][start] = true;
		while(!deque.isEmpty()) {
			int curr = deque.poll();
			for(Node node : edge[curr]) {
				int des = node.x;
				int o = node.order;
				if(!visited[des] && o==order) {
					visited[des] = true;
					check[start][des] = true;
					deque.add(des);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			edge = new List[N+1];
			check = new boolean[N+1][N+1];
			for(int i =1; i<=N; i++) {
				edge[i] = new ArrayList<Node>();
			}
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edge[a].add(new Node(b,1));
				edge[b].add(new Node(a,0));
			}
			for(int i = 1; i<=N; i++) {
				bfs(i,0);
				bfs(i,1);
			}
			int answer = N;
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					if(!check[i][j]) {
						answer-=1;
						break;
					}
				}
			}
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	} 
	
}