import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 벨만포드로 각 정점에서 정점까지 최단 거리 구함.
		// 탐색 돌아서 max값 탐색

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] item = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], 1000000000);
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			dist[a - 1][b - 1] = d;
			dist[b - 1][a - 1] = d;
		}
		for (int i = 0; i < n; i++) {
			dist[i][i] = 0;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					dist[j][k] = Math.min(dist[j][k], (dist[j][i] + dist[i][k]));
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (dist[i][j] <= m) {
					sum += item[j];
				}
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);

	}
}