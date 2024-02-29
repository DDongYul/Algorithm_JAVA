import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static boolean check(int i, int j) {
		if (i >= 0 && i < N && j >= 0 && j < M && arr[i][j] != 1) {
			return true;
		}
		return false;
	}

	static int K, N, M;
	static int[][] arr;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[] hx = { -2, -2, 2, 2, -1, -1, 1, 1 };
	static int[] hy = { -1, 1, -1, 1, -2, 2, -2, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		if(N==1 && M==1) {
			System.out.println(0);
			System.exit(0);
		}

		arr = new int[N][M];
		int[][][] DP = new int[N][M][K+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		System.out.println("x: " + x + "y: " + y + "k: " + k);
		Deque<int[]> deque = new ArrayDeque<int[]>();
		deque.add(new int[] { 0, 0, K });
		while (!deque.isEmpty()) {
			int[] curr = deque.removeFirst();
			int x = curr[0];
			int y = curr[1];
			int k = curr[2];
			
//			System.out.println("x: " + x + "y: " + y + "k: " + k);

			// 나이트 이동
			if (k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = x + hx[i];
					int ny = y + hy[i];
					if (check(nx, ny)) {
						if (DP[nx][ny][k-1] == 0) {
							DP[nx][ny][k-1] = DP[x][y][k] + 1;
							deque.add(new int[] { nx, ny, k-1 });
						}
					}
				}
			}

			// 인접 이동
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (check(nx, ny)) {
					if (DP[nx][ny][k] == 0) {
						DP[nx][ny][k] = DP[x][y][k] + 1;
						deque.add(new int[] { nx, ny, k });
					}
				}
			}

		}
		
		int answer = Integer.MAX_VALUE;
		for (int num : DP[N-1][M-1]) {
			if(num != 0) {
				answer = Math.min(answer, num);
			}
		}
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {			
			System.out.println(answer);
		}
	}

}