import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	static char[] leftP = { '{', '[', '(', '<' };
	static char[] rightP = { '}', ']', ')', '>' };

	static int getInt(char c) {
		for(int i = 0; i<4; i++) {
			if(leftP[i] == c) {
				return i;
			}
		}
		for(int i = 0; i<4; i++) {
			if(rightP[i] == c) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		char[] leftP = { '{', '[', '(', '<' };
		char[] rightP = { '}', ']', ')', '>' };

		for (int t = 0; t < 10; t++) {
			sb.append("#").append(t + 1).append(" ");
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			boolean valid = true;
			for (int i = 0; i < len; i++) {
				char curr = str.charAt(i);
				boolean flag = true; // 왼쪽 true 오른쪽 false
				
				//괄호 방향 확인
				for (char c : rightP) {
					if (c == curr) {
						flag = false;
						break;
					}
				}
				//왼쪽괄호면
				if (flag) {
					left.add(curr);
				}
				//오른쪽 괄호면
				else {
					if (left.isEmpty()) {
						valid = false;
						break;
					}
					char r = left.pop();
					if (!(getInt(curr) == getInt(r))) {
						valid = false;
						break;
					}
				}
			}
			if (valid) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

}