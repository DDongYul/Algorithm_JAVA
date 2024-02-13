import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] arr1;
	static int[] arr2;
	static boolean[] visited;
	static int a;
	static int b;

	static void search(int depth, int score1, int score2, int next) {
		if (depth == 8) {
			if (arr1[depth] > arr2[next]) {
				score1 += arr1[depth] + arr2[next];
			} else {
				score2 += arr1[depth] + arr2[next];
			}
			
			if (score1 > score2) {
				a += 1;
			} else if (score2 > score1) {
				b += 1;
			}
			return;
		}
		if (depth == -1) {
			
		} else {
			if (arr1[depth] > arr2[next]) {
				score1 += arr1[depth] + arr2[next];
			} else {
				score2 += arr1[depth] + arr2[next];
			}
		}
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				search(depth + 1, score1, score2, i);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			arr1 = new int[9];
			arr2 = new int[9];
			visited = new boolean[9];
			a = 0;
			b = 0;
			boolean[] temp = new boolean[19];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr1[i] = num;
				temp[num] = true;
			}
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!temp[i]) {
					arr2[idx++] = i;
				}
			}
			search(-1, 0, 0, 0);
			sb.append("#").append(t + 1).append(" ").append(a).append(" ").append(b).append("\n");
		}
		System.out.println(sb);

	}
}