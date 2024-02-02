import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 하나의 그룹이면 가능 공통 루트를 찾았을 때 모두 같아야한다.
 *
 */
public class Main {

	static class Node{
		int value;
		List<Node> list;
		
		public Node(int value) {
			this.value = value;
			list = new ArrayList<Node>();
		}
		
	}

	static Node[] node;
	static boolean visited[];
	
	static void BFS(int start) {
		visited[start] = true;
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.add(start);
		while(!deque.isEmpty()) {
			int curr = deque.removeFirst();
			for (Node node : node[curr].list) {
				int val = node.value;
				if(!visited[val]) {
					visited[val] = true;
					deque.addLast(val);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		node = new Node[N+1];
		for(int i = 0; i<N+1; i++) {
			node[i] = new Node(i);
		}
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					node[i].list.add(node[j]);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine()); //
		BFS(Integer.parseInt(st.nextToken()));
		//BFS를 돌렸는데 해당 값을 방문 안했으면 NO
		for (int i = 0; i < M - 1; i++) {
			if (!visited[Integer.parseInt(st.nextToken())]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}