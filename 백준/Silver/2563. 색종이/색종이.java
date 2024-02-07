import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[][] arr = new int[101][101];
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int t = 0; t<N; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i = x; i<x+10; i++) {
				for(int j = y; j<y+10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		for(int i = 0; i<101; i++) {
			for(int j = 0; j<101; j++) {
				if(arr[i][j] == 1) {
					answer+=1;
				}
			}
		}
		System.out.println(answer);
		
	}
}