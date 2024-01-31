import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	static int[][] arr;
	static int cnt;

	static void sol(int x, int y, int n, int flag) {
		if (n == 0) {
			return;
		}
		// 0 오, 1 아, 2 왼, 3 위
		switch (flag) {
		case 0: {
			for (int i = 0; i < n; i++) {
				arr[x][y++] = cnt++;
			}
			y--;
			sol(x+1, y, n - 1, 1);
		}
			break;
		case 1: {
			for (int i = 0; i < n; i++) {
				arr[x++][y] = cnt++;
			}
			x--;
			sol(x, y-1, n, 2);
		}
			break;

		case 2: {
			for (int i = 0; i < n; i++) {
				arr[x][y--] = cnt++;
			}
			y++;
			sol(x-1, y, n - 1, 3);
		}
			break;

		case 3: {
			for (int i = 0; i < n; i++) {
				arr[x--][y] = cnt++;
			}
			x++;
			sol(x, y+1, n, 0);
		}
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			cnt=1;
			int n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			sol(0,0,n,0);
			sb.append("#").append(t+1).append("\n");
			for(int i = 0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}