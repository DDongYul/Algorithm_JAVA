import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] arr;
	static List<Point> coreList;
	static int N, minWire, maxCore;

	public static void sol(int depth, int coreCnt, int wireCnt) {
		if (depth == coreList.size()) {
			if (maxCore < coreCnt) { // 코어 수 최대일 때
				maxCore = coreCnt;
				minWire = wireCnt;
			} else if (maxCore == coreCnt) { // 코어 수 같고 전선길이의 합이 최소일 때
				minWire = Math.min(wireCnt, minWire);
			}
			return;
		}

		// 인덱스 위치의 코어의 좌표
		int x = coreList.get(depth).x;
		int y = coreList.get(depth).y;

		// 상 하 좌 우 탐색
		for (int i = 0; i < 4; i++) {
			int count = 0;
			int nx = x;
			int ny = y;

			while (true) {
				nx += dx[i];
				ny += dy[i];
				// 범위를 벗어나면 (연결 성공)
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					break;
				}
				// 가는 길에 코어 또는 전선을 만나면
				if (arr[nx][ny] == 1) {
					count = 0;
					break;
				}
				count++;
			}

			// 전선 부분 1로 채워주기
			int cntX = x;
			int cntY = y;

			for (int j = 0; j < count; j++) {
				cntX += dx[i];
				cntY += dy[i];
				arr[cntX][cntY] = 1;
			}

			if (count == 0) {	//연결 안했다면
				sol(depth + 1, coreCnt, wireCnt);
			} else {
				sol(depth + 1, coreCnt + 1, wireCnt + count);

				// 전선부분 다시 0으로
				cntX = x;
				cntY = y;

				for (int j = 0; j < count; j++) {
					cntX += dx[i];
					cntY += dy[i];
					arr[cntX][cntY] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			coreList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {	//코어일 때
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
							continue;	//가장자리는 안 넣어줌
						}
						coreList.add(new Point(i, j));
					}

				}
			}

			maxCore = 0;
			minWire = Integer.MAX_VALUE;
			sol(0, 0, 0);
			sb.append("#").append(t+1).append(" ").append(minWire).append("\n");
		}
		System.out.println(sb);

	}
}