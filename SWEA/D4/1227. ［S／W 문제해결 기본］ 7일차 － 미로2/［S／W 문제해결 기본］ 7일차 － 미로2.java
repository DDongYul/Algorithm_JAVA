import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int[][] arr;
	static boolean[][] visited;
	static Point start;
	static Point end;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	

	private static boolean BFS(Point s) {
		Deque<Point> deque = new ArrayDeque<Point>();
		deque.add(s);
		while(!deque.isEmpty()) {
			Point curr = deque.removeFirst();
			int x = curr.x;
			int y = curr.y;
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && nx<100 && ny>=0 && ny<100 && arr[nx][ny]!=1 && !visited[nx][ny]) {
					if(arr[nx][ny] == 3) {
						return true;
					}
					visited[nx][ny] = true;
					deque.add(new Point(nx,ny));
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
			int tm = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			visited = new boolean[100][100];
			
			for(int i = 0; i<100; i++) {
				String str = br.readLine();
				for(int j =0; j<100; j++) {
					arr[i][j] = str.charAt(j) - '0';
					if(arr[i][j] == 2) {
						start = new Point(i,j);
					}
					if(arr[i][j] == 3) {
						end = new Point(i,j);
					}
				}
			}
			sb.append("#").append(tm).append(" ");
			visited[start.x][start.y]= true;
			if(BFS(start)){
				sb.append(1);
			}else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}