import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dna;
	static int cntA;
	static int cntC;
	static int cntG;
	static int cntT;

	static boolean check() {
		if (dna[0] > cntA) {
			return false;
		}
		if (dna[1] > cntC) {
			return false;
		}
		if (dna[2] > cntG) {
			return false;
		}
		if (dna[3] > cntT) {
			return false;
		}
		return true;
	}

	static void update(char c, boolean flag) {
		// flag true: +
		if (flag) {
			if (c == 'A') {
				cntA += 1;
			}
			if (c == 'C') {
				cntC += 1;
			}
			if (c == 'G') {
				cntG += 1;
			}
			if (c == 'T') {
				cntT += 1;
			}
		}
		// flag false: -
		else {
			if (c == 'A') {
				cntA -= 1;
			}
			if (c == 'C') {
				cntC -= 1;
			}
			if (c == 'G') {
				cntG -= 1;
			}
			if (c == 'T') {
				cntT -= 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// 투 포인터 (문자열 개수 처음에 세주고
		// 앞쪽 빠진거 -1개 뒤 문자 +1개
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		dna = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			dna[i] = Integer.parseInt(st.nextToken());
		}

		cntA = 0;
		cntC = 0;
		cntG = 0;
		cntT = 0;

		int front = 0;
		int back = P - 1;
		int answer = 0;

		for (int i = 0; i <= back; i++) {
			if (str.charAt(i) == 'A') {
				cntA += 1;
			}
			if (str.charAt(i) == 'C') {
				cntC += 1;
			}
			if (str.charAt(i) == 'G') {
				cntG += 1;
			}
			if (str.charAt(i) == 'T') {
				cntT += 1;
			}
		}

		while (back < S) {
			if (check()) {
				answer += 1;
			}
			update(str.charAt(front), false);
			front++;
			back++;
			if (back < S) {
				update(str.charAt(back), true);
			}
		}
		System.out.println(answer);
	}
}