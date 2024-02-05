import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("<");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		LinkedList<Integer> lst = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			lst.add(i);
		}
		int idx = K - 1;
		while (!lst.isEmpty()) {
			sb.append(lst.remove(idx));
			if (lst.size() == 0) {
				sb.append(">");
				break;
			} else {
				sb.append(",").append(" ");
				idx -= 1;
				idx = (idx + K) % lst.size();
			}
		}
		System.out.println(sb);
	}
}