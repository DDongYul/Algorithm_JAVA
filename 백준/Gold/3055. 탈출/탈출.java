import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	/**
	 * . : 비어있음 * : 물 X : 돌
	 */
	static int R, C, startX, startY, endX, endY;
	static char[][] board;
	static int[][] waterBoard;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Deque<int[]> water;
	static Deque<int[]> hedgehog;

	static boolean[][] visited;

	// 먼저 물 채우기
	private static void BFSWater() {
		while (!water.isEmpty()) {
			int[] w = water.poll();
			int x = w[0];
			int y = w[1];
			int val = w[2];
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] == '.' && waterBoard[nx][ny] == Integer.MAX_VALUE) {
					waterBoard[nx][ny] = val+1;
					water.add(new int[] { nx, ny, val + 1 });
				}
			}
		}
	}

	private static int BFSHedgehog() {
		while (!hedgehog.isEmpty()) {
			int[] h = hedgehog.poll();
			int x = h[0];
			int y = h[1];
			int val = h[2];
//			System.out.println("x: " + x + " y: " + y + " val: " + val);
			
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
//				System.out.println("nx: " + nx + " ny: " + ny);
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && (board[nx][ny] == '.'|| board[nx][ny] == 'D') && !visited[nx][ny]) {
					if (nx == endX && ny == endY) {
						return val+1;
					}
					if(val+1>=waterBoard[nx][ny]) {
						continue;
					}
					visited[nx][ny] = true;
					hedgehog.add(new int[] { nx, ny, val + 1 });
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		water = new ArrayDeque<int[]>();
		waterBoard = new int[R][C];
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				waterBoard[i][j] = Integer.MAX_VALUE;
			}
		}
		
		hedgehog = new ArrayDeque<int[]>();
		visited = new boolean[R][C];


		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
				if (str.charAt(j) == 'S') {
					startX = i;
					startY = j;
					visited[startX][startY] = true;
					hedgehog.add(new int[] { i, j, 0 });
				} else if (str.charAt(j) == 'D') {
					endX = i;
					endY = j;
				} else if (str.charAt(j) == '*') {
					water.add(new int[] { i, j, 0 });
					waterBoard[i][j] = 0;
				}
			}
		}

		BFSWater();
		
//		for(int i = 0; i<R; i++) {
//			System.out.println(Arrays.toString(waterBoard[i]));
//		}
		
		int answer = BFSHedgehog();
		System.out.println(answer == -1 ? "KAKTUS" : answer);

	}

}