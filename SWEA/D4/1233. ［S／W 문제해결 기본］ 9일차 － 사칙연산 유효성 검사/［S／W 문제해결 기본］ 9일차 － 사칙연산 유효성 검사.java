import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		List<String> operator = Arrays.asList("-", "+", "*", "/");

		for (int t = 0; t < 10; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean flag = true;
			sb.append("#").append(t + 1).append(" ");
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				String c = st.nextToken();
				if (flag && n <= N / 2) {
					if (!operator.contains(c)) {
						sb.append(0).append("\n");
						flag = false;
					}
				} else if(flag && n>N/2){
					if (operator.contains(c)) {
						sb.append(0).append("\n");
						flag = false;
					}
				}
			}
			if(flag) {
				sb.append(1).append("\n");
			}
		}
		System.out.println(sb);
	}
}