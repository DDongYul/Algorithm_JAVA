import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			int[][] radder = new int[100][100];
			int x = 0;
			int y = 0;
			int value;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					value = Integer.parseInt(st.nextToken());
					if (value == 2) {
						x = i;
						y = j;
					}
					radder[i][j] = value;
				}
			}
			while (x > 0) {
				//왼쪽으로 이동
				if(y-1>=0 && radder[x][y-1] == 1) {
					while(radder[x][y-1]==1) {
						y=y-1;
						if(y==0) {
							break;
						}
					}
				}
				//오른쪽 이동
				else if(y+1<100 && radder[x][y+1] == 1) {
					while(radder[x][y+1]==1) {
						y=y+1;
						if(y==99) {
							break;
						}
					}
				}
				x-=1;
			}
			StringBuilder sb = new StringBuilder("#").append(T).append(" ").append(y);
			System.out.println(sb);
		}
	}
}