import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 상하 반전
	static void turn1() {
		if (flag) {
			for (int i = 0; i < M / 2; i++) {
				for (int j = 0; j < N; j++) {
					int temp = arr2[M - i - 1][j];
					arr2[M - i - 1][j] = arr2[i][j];
					arr2[i][j] = temp;
				}
			}
		} else {
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M; j++) {
					int temp = arr[N - i - 1][j];
					arr[N - i - 1][j] = arr[i][j];
					arr[i][j] = temp;
				}
			}
		}

	}

	// 좌우 반전
	static void turn2() {
		if (flag) {
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M; j++) {
					int temp = arr2[j][N - i - 1];
					arr2[j][N - i - 1] = arr2[j][i];
					arr2[j][i] = temp;
				}
			}
		} else {
			for (int i = 0; i < M / 2; i++) {
				for (int j = 0; j < N; j++) {
					int temp = arr[j][M - i - 1];
					arr[j][M - i - 1] = arr[j][i];
					arr[j][i] = temp;
				}
			}
		}
	}

	// 오른쪽 90도 회전
	static void turn3() {
		// 돌아가 있으면 (m*n)
		if (flag) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][M - j - 1] = arr2[j][i];
				}
			}
		} else {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					arr2[i][N - j - 1] = arr[j][i];
				}
			}
		}
	}

	static void turn4() {
		// 왼쪽 90도 회전
		if (flag) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[N - i - 1][j] = arr2[j][i];
				}
			}
		} else {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					arr2[M - i - 1][j] = arr[j][i];
				}
			}
		}
	}

	static void turn6() {
		if (flag) {
			// 1 복사
			int[][] temp = new int[M / 2][N / 2];
			for (int i = 0; i < M / 2; i++) {
				temp[i] = Arrays.copyOf(arr2[i], N / 2);
			}

			// 4 -> 1
			for (int i = M / 2; i < M; i++) {
				for (int j = N / 2; j < N; j++) {
					arr2[i - M / 2][j - N / 2] = arr2[i - M / 2][j];
				}
			}

			// 3 -> 4
			for (int i = M / 2; i < M; i++) {
				for (int j = N / 2; j < N; j++) {
					arr2[i - M / 2][j] = arr2[i][j];
				}
			}

			// 2 -> 3
			for (int i = M / 2; i < M; i++) {
				for (int j = N / 2; j < N; j++) {
					arr2[i][j] = arr2[i][j - N / 2];
				}
			}

			// 1-> 2
			for (int i = M / 2; i < M; i++) {
				for (int j = N / 2; j < N; j++) {
					arr2[i][j - N / 2] = temp[i - M / 2][j - N / 2];
				}
			}

		} else {
			// 1 복사
			int[][] temp = new int[N / 2][M / 2];
			for (int i = 0; i < N / 2; i++) {
				temp[i] = Arrays.copyOf(arr[i], M / 2);
			}

			// 4 -> 1
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i - N / 2][j - M / 2] = arr[i - N / 2][j];
				}
			}

			// 3 -> 4
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i - N / 2][j] = arr[i][j];
				}
			}

			// 2 -> 3
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i][j] = arr[i][j - M / 2];
				}
			}

			// 1-> 2
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i][j - M / 2] = temp[i - N / 2][j - M / 2];
				}
			}
		}
	}

	static void turn5() {
		if (flag) {
			// 1 복사
			int[][] temp = new int[M / 2][N / 2];
			for (int i = 0; i < M / 2; i++) {
				temp[i] = Arrays.copyOf(arr2[i], N / 2);
			}
			// 4 -> 1
			for (int i = M / 2; i < M; i++) {
				for (int j = N / 2; j < N; j++) {
					arr2[i - M / 2][j - N / 2] = arr2[i][j - N / 2];
				}
			}
			// 3 -> 4
			for (int i = M / 2; i < M; i++) {
				for (int j = N / 2; j < N; j++) {
					arr2[i][j - N / 2] = arr2[i][j];
				}
			}
			// 2 -> 3
			for (int i = M / 2; i < M; i++) {
				for (int j = N / 2; j < N; j++) {
					arr2[i][j] = arr2[i - M / 2][j];
				}
			}
			// 1-> 2
			for (int i = M / 2; i < M; i++) {
				for (int j = N / 2; j < N; j++) {
					arr2[i - M / 2][j] = temp[i - M / 2][j - N / 2];
				}
			}

		} else {
			// 1 복사
			int[][] temp = new int[N / 2][M / 2];
			for (int i = 0; i < N / 2; i++) {
				temp[i] = Arrays.copyOf(arr[i], M / 2);
			}
			// 4 -> 1
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i - N / 2][j - M / 2] = arr[i][j - M / 2];
				}
			}
			// 3 -> 4
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i][j - M / 2] = arr[i][j];
				}
			}
			// 2 -> 3
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i][j] = arr[i - N / 2][j];
				}
			}
			// 1-> 2
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i - N / 2][j] = temp[i - N / 2][j - M / 2];
				}
			}
		}
	}

	static int N;
	static int M;
	static int arr[][];
	static int arr2[][];
	static boolean flag; // 돌아가있는지

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		arr2 = new int[M][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
			}
		}

		st = new StringTokenizer(br.readLine());
		while (!st.hasMoreElements()) {
			int o = Integer.parseInt(st.nextToken());
		}

		flag = false;
		for (int i = 0; i < R; i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1: {
				turn1();
			}
				break;
			case 2: {
				turn2();
			}
				break;
			case 3: {
				turn3();
				if (flag)
					flag = false;
				else
					flag = true;
			}
				break;
			case 4: {
				turn4();
				if (flag)
					flag = false;
				else
					flag = true;
			}
				break;
			case 5: {
				turn5();
			}
				break;
			case 6: {
				turn6();
			}
				break;

			}
		}

		if (flag) {
			for (int i = 0; i < M; i++) {
				for(int j = 0; j<N; j++) {
					sb.append(arr2[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		else {
			for (int i = 0; i < N; i++) {
				for(int j = 0; j<M; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}			
		}
		System.out.println(sb);
	}
}