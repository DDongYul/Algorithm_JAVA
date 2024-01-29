import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int[][] graph;

	static int search(int x, int y) {
		int[] dx = { 0, 1, 1, -1 };
		int[] dy = { 1, 1, 0, 1 };

		int max = 0;
		int curr = graph[x][y];
		boolean flag;
		int cnt, curr_x, curr_y;

		for (int k = 0; k < 4; k++) {
			if(k==0 && 0<=y-1 && graph[x][y-1] == curr){
					continue;
			}
			else if(k==1 && 0<=x-1 && 0<=y-1 && graph[x-1][y-1] == curr) {
				continue;
			}
			else if(k==2 && 0<=x-1 && graph[x-1][y] == curr) {
				continue;
			}
			else if(k==3 && x+1<19 && y-1>=0 && graph[x+1][y-1] == curr) {
				continue;
			}
			
			flag = true;
			cnt = 1;
			curr_x = x;
			curr_y = y;
			while (flag) {
				curr_x += dx[k];
				curr_y += dy[k];
				if (0 <= curr_x && curr_x < 19 && 0 <= curr_y && curr_y < 19 && graph[curr_x][curr_y] == curr) {
					cnt += 1;
				} else {
					flag = false;
					if(cnt == 5) {
						return 5;
					}
					max = Math.max(max, cnt);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 19;
		graph = new int[N][N];

		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (graph[j][i] == 1 || graph[j][i] == 2) {
					if (search(j, i) == 5) {
						System.out.println(graph[j][i]);
						System.out.print((j + 1) + " ");
						System.out.print((i + 1));
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
}