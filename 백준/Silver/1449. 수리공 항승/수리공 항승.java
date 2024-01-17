import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int mx = 0;
		for (int i = 0; i < arr.length; i++) {
			int num = Integer.parseInt(st.nextToken());
			mx = Math.max(num, mx);
			arr[i] = num;
		}
		int[] arr2 = new int[mx+1];
		for (int i = 0; i < arr.length; i++) {
			arr2[arr[i]] = 1;
		}
		
		int ans = 0;
		for (int i = 0; i < arr2.length; i++) {
			if(arr2[i]!=0) {
				for(int j=i; j<i+L; j++) {
					if(j>mx) {
						break;
					}
					arr2[j] = 0;
				}
				ans+=1;
			}
		}
		System.out.println(ans);
	}
}