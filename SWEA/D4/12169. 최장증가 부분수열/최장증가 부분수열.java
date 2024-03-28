import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static int binarySearch(int[] arr, int key) {
		int idx = Arrays.binarySearch(arr, key);
		return (idx<0) ? -idx-1 : idx;
	}
	
	//해당 인덱스를 이분탐색을 통해 위치를 찾아줌 
	private static int LIS(int[] arr) {
		int answer = 1;
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		for(int i = 1; i<arr.length; i++) {
			int num = arr[i];
			int idx = binarySearch(Arrays.copyOf(dp, answer), num);
			//맨 끝(제일 큰 값)
			if(idx==answer) {
				dp[answer] = num;
				answer+=1;
				continue;
			}
			//맨 앞(제일 작은 값)
			if(idx == 0) {
				dp[0] = num;
				continue;
			}
			//중간에 들어가는 경우
			dp[idx] = num;
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(t+1).append(" ").append(LIS(arr)).append("\n");
		}
		System.out.println(sb);
		
	}
}