import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int[] count;

	static int find(int x) {
		while (x != parent[x]) {
			x = parent[x];
		}
		return x;
	}

	static int union(int a, int b) {
		int aP = find(a);
		int bP = find(b);
		if (aP == bP) {
			return count[aP];
		} else if (aP < bP) {
			parent[bP] = aP;
			count[aP] += count[bP];
			return count[aP];
		} else {
			parent[aP] = bP;
			count[bP] += count[aP];
			return count[bP];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int F = Integer.parseInt(br.readLine());

			parent = new int[F * 2]; //
			for (int i = 0; i < F * 2; i++) {
				parent[i] = i;
			}

			count = new int[F * 2];
			for (int i = 0; i < F * 2; i++) {
				count[i] = 1;
			}

			int idx = 0;
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				int a, b; // 두 input의 index
				if (map.get(str1) != null) {
					a = map.get(str1);
				} else {
					a = idx;
					map.put(str1, idx);
					idx++;
				}
				if (map.get(str2) != null) {
					b = map.get(str2);
				} else {
					b = idx;
					map.put(str2, idx);
					idx++;
				}
				sb.append(union(a, b)).append("\n");
			}
		}
		System.out.println(sb);
	}

}