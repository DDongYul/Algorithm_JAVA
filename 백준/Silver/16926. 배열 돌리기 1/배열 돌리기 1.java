import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static void turn(int[][] arr1, int[][] arr2) {
		int mIdx = 0;
		int nIdx = 0;
		while (mIdx < (M / 2) && nIdx < (N / 2)) {
			// 왼쪽 세로
			for (int i = N-nIdx-1; i > nIdx; i--) {
				arr1[i][mIdx] = arr2[i - 1][mIdx];
			}

			// 아래
			for (int i = M-mIdx-1; i > mIdx; i--) {
				arr1[N - nIdx - 1][i] = arr2[N - nIdx - 1][i - 1];
			}

			// 오른쪽 세로
			for (int i = nIdx; i < N - 1 - nIdx; i++) {
				arr1[i][M - mIdx - 1] = arr2[i + 1][M - mIdx - 1];
			}

			// 위
			for (int i = mIdx; i < M - 1 - mIdx; i++) {
				arr1[nIdx][i] = arr2[nIdx][i + 1];
			}
			nIdx += 1;
			mIdx += 1;
		}
	}

	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int[][] arr2 = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				arr2[i][j] = num;
			}
		}

		for (int i = 0; i < R; i++) {
			if (i % 2 == 0) {
				turn(arr2, arr);
			} else {
				turn(arr, arr2);
			}
		}

		if (R % 2 == 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(arr2[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}