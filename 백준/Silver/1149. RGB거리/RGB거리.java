import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[3][N];
		
		st = new StringTokenizer(br.readLine());
		arr[0][0] = Integer.parseInt(st.nextToken()); 	
		arr[1][0] = Integer.parseInt(st.nextToken()); 	
		arr[2][0] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][i] = Math.min(arr[1][i-1], arr[2][i-1]) + Integer.parseInt(st.nextToken());
			arr[1][i] = Math.min(arr[0][i-1], arr[2][i-1]) + Integer.parseInt(st.nextToken());
			arr[2][i] = Math.min(arr[0][i-1], arr[1][i-1]) + Integer.parseInt(st.nextToken());
		}
		
		int answer = Math.min(Math.min(arr[0][N-1],arr[1][N-1]), arr[2][N-1]);
		System.out.println(answer);
		
	}

}