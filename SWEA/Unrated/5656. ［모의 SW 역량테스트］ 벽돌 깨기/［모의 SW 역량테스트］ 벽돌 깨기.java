import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백트래킹 -> 9^4
 * 모두 부숴지는 경우 (고려 안해도 될듯)
 * 
 */
public class Solution {
	
	static class Point{
		int x;
		int y;
		int val;
		
		public Point(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
		
	}

	static int N, W, H, answer, cnt;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] board;
	static Deque<Point> deque;
	
	private static boolean check() {
		boolean flag = true;
		for(int i = 0; i<W; i++) {
			for(int j = 0; j<H; j++) {
				if(board[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void move() {
		for(int i = 1; i<=H; i++) {
			int cx = W-1;
			int ccx;
			int y = H-i;
			while(cx>1) {
				while(board[cx][y]!=0) {
					cx-=1;
					if(cx<1) {
						break;
					}
				}
				if(cx<1) {
					break;
				}
				ccx = cx-1;
				while(ccx>=0 && board[ccx][y]==0) {
					ccx-=1;
				}
				if(ccx>=0) {
					board[cx][y] = board[ccx][y];
					board[ccx][y] = 0;
				}
				cx-=1;
			}
			
		}
	}
	
	private static void sol(int depth) {
		if(depth == N) {
			answer = Math.max(answer, cnt);
			return;
		}
		if(check()) {
			answer = Math.max(answer, cnt);
			return;
		}
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				if(board[j][i]!=0) {
					int[][] arr = new int[W][H];
					for(int m = 0; m<W; m++) {
						for(int n=0; n<H; n++) {
							arr[m][n] = board[m][n];
						}
					}
					int res = BFS(new Point(j,i,board[j][i]));
					cnt+=res;
					move();
					sol(depth+1);
					cnt-=res;
					for(int m = 0; m<W; m++) {
						for(int n=0; n<H; n++) {
							board[m][n] = arr[m][n];
						}
					}
					break;
				}
			}
		}
	}
	
	private static int BFS(Point start) {
		int res = 1;
		deque.add(start);
		while(!deque.isEmpty()) {
			Point curr = deque.poll();
			int x = curr.x;
			int y = curr.y;
			int val = curr.val;
			board[x][y] = 0;
			for(int i = 0; i<4; i++) {
				for(int j = 1; j<val; j++) {
					int nx = x+dx[i]*j;
					int ny = y+dy[i]*j;
					if(nx>=0 && nx<W && ny>=0 && ny<H && board[nx][ny]!=0) {
						Point next = new Point(nx,ny,board[nx][ny]);
						board[nx][ny] = 0;
						deque.add(next);
						res+=1;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int total = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			answer = 0;
			cnt = 0;
			deque = new ArrayDeque<>();
			board = new int[W][H];
			
			for(int i = 0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<H; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j] !=0) {
						total+=1;
					}
				}
			}
			sol(0);
			sb.append("#").append(t+1).append(" ").append(total - answer).append("\n");
		}
		System.out.println(sb);

	}
}
