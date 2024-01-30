import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0; t<10; t++) {
			
			int n = Integer.parseInt(br.readLine()); //덤프 횟수
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[100];
			for(int i = 0; i<100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int answer = 1001;
			for(int i = 0; i<n+1; i++) {	//n+1번 돌려서 마지막 값 갱신
				int min = 1001;
				int max = 0;
				int minIndex = 0;
				int maxIndex = 0;
				for(int j = 0; j<100; j++) {
					if(min>arr[j]) {
						min = arr[j];
						minIndex = j;
					}
					if(max<arr[j]) {
						max = arr[j];
						maxIndex = j;
					}
				}
				arr[minIndex]++;
				arr[maxIndex]--;
				answer = Math.min(answer,max-min);
			}
			StringBuilder sb = new StringBuilder("#").append(t+1).append(" ").append(answer);
			System.out.println(sb);
		}
		
	}

}