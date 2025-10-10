import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        
        int min6 = 1000;
        int min1 = 1000;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			min6 = Math.min(min6, a);
            min1 = Math.min(min1, b);
		}
        
        if(min1*6<min6){
            min6 = min1*6;
        }
        
        int answer = (N/6)*min6 + Math.min((N%6)*min1, min6);
		System.out.println(answer);
	}
}