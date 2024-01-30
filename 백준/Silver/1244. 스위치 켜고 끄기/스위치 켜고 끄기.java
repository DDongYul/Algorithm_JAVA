import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[0] = -1;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				boy(Integer.parseInt(st.nextToken()));
			} else{
				girl(Integer.parseInt(st.nextToken()));
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<N+1; i++) {
			sb.append(arr[i]).append(" ");
			if(i%20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void girl(int s) {
		arr[s] = 1 - arr[s];
		int p1 = s - 1;
		int p2 = s + 1;
		while (p1 >= 1 && p2 <= N) {
			if (arr[p1] != arr[p2]) {
				break;
			}
			arr[p1] = 1 - arr[p1];
			arr[p2] = 1 - arr[p2];
			p1 -= 1;
			p2 += 1;
		}
	}

	private static void boy(int s) {
		for (int i = s; i < N + 1; i += s) {
			arr[i] = 1 - arr[i];
		}
	}
}