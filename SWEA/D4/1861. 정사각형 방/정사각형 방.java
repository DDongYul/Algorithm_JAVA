import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int BFS(Point point) {
		int cnt = 0;
		Deque<Point> deque = new ArrayDeque<Point>();
		deque.add(point);
		while(!deque.isEmpty()) {
			cnt+=1;
			Point curr = deque.removeFirst();
			visited[curr.x][curr.y] = true;
			for(int i = 0; i<4; i++) {
				int xx = curr.x+dx[i];
				int yy = curr.y+dy[i];
				if(xx>=0 && xx<N && yy>=0 && yy<N &&
						(arr[xx][yy] - arr[curr.x][curr.y])==1) {
					deque.add(new Point(xx, yy));
				}
			}
			
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int num = 100000000;
			int answer = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(!visited[i][j]) {
						int cnt = BFS(new Point(i, j));
						if(cnt == answer) {	//같을 때
							num = Math.min(num, arr[i][j]);
						}
						if(cnt>answer) {
							num = arr[i][j];
							answer = cnt;
						}
					}
				}
			}
			sb.append("#").append(t+1).append(" ").append(num).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
}