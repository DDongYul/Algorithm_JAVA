import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	//100번
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			List<Point> store = new ArrayList<Point>();
			Deque<Point> deque = new ArrayDeque<Point>();
			//Start
			st = new StringTokenizer(br.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
			deque.add(start);
			//편의점
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				store.add(new Point(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}
			//End
			st = new StringTokenizer(br.readLine());
			Point end = new Point(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
			store.add(end);
			
			boolean[] visited = new boolean[N+1];
			boolean flag = false;
			loop: while(!deque.isEmpty()) {
				Point curr = deque.poll();
				for(int i = 0; i<N+1; i++) {
					Point p = store.get(i);
					int dist = Math.abs(curr.x-p.x) + Math.abs(curr.y-p.y);
					if(!visited[i] && dist<=1000){
						if(p.x == end.x && p.y == end.y) {
							flag = true;
							break loop;
						}
						deque.add(p);
						visited[i] = true;
					}
				}
			}
			if(flag) {
				sb.append("happy").append("\n");
			}
			else {
				sb.append("sad").append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
}