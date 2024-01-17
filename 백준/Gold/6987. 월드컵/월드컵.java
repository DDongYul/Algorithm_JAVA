import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[] home = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] away = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int[][] rst = new int[6][3];
	static List<int[][]> input = new ArrayList();
	static int[] ans = {0,0,0,0};
	
	public static void sol(int depth) {
		if(depth == 15) {
			for (int i = 0; i < 4; i++) {
				if(Arrays.deepEquals(input.get(i), rst)) {
					ans[i] = 1;
				}
			}
			return;
		}
		int h = home[depth];
		int a = away[depth];
		for(int i=0; i<3; i++) {
			if(i==0) {
				rst[h][0] +=1;
				rst[a][2] +=1;
				sol(depth+1);
				rst[h][0] -=1;
				rst[a][2] -=1;
			}
			if(i==1) {
				rst[h][1] +=1;
				rst[a][1] +=1;
				sol(depth+1);
				rst[h][1] -=1;
				rst[a][1] -=1;
			}
			if(i==2) {
				rst[h][2] +=1;
				rst[a][0] +=1;
				sol(depth+1);
				rst[h][2] -=1;
				rst[a][0] -=1;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=0; t<4; t++) {
			int[][] arr = new int[6][3];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<6; i++) {
				for(int j=0; j<3; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			input.add(arr);
		}
		sol(0);
		for (int i = 0; i < 4; i++) {
			System.out.print(ans[i] + " ");			
		}
	}
}