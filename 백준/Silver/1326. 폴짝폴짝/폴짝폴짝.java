import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] visited;
	static ArrayDeque<Integer> deque = new ArrayDeque<>();
	static int[] arr;
	static int N;

	static void BFS(int start) {
		deque.addFirst(Integer.valueOf(start));
		while (!deque.isEmpty()) {
			Integer curr = deque.removeFirst();
			int cnt = visited[curr];
			int idx = arr[curr];
			for (int i = curr; i < N + 1; i += idx) {
				if (visited[i] == 0) {
					visited[i] = cnt+1;
					deque.addLast(i);
				}
			}
			for (int i = curr; i >0; i -= idx) {
				if (visited[i] == 0) {
					visited[i] = cnt+1;
					deque.addLast(i);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		visited = new int[N + 1];
		BFS(a);
//		System.out.println(Arrays.toString(visited));
		if(visited[b] == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(visited[b]);			
		}
		
	}
}