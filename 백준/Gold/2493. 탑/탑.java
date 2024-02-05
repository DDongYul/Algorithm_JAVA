import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Top{
		int index;
		int value;
		
		public Top(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		Top[] tops = new Top[N+1];
		for(int i = 1; i<=N; i++) {
			tops[i] = new Top(i,Integer.parseInt(st.nextToken()));
		}
		Stack<Top> stack = new Stack<>();
		stack.push(tops[N]);
		for(int i = N-1; i>=1; i--) {
			while(!stack.isEmpty() && stack.peek().value<=tops[i].value) {
					Top curr = stack.pop();
					arr[curr.index] = i;
			}	
		stack.push(tops[i]);
			
		}
		for(int i = 1; i<=N; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
		
	}
}