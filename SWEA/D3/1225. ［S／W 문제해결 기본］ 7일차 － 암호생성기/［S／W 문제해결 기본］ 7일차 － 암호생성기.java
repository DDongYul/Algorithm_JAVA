import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<10; t++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st =  new StringTokenizer(br.readLine());
			Deque<Integer> deque = new ArrayDeque<>();
			for(int i = 0; i<8; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			int idx = 1;
			while(true) {
				int num = deque.removeFirst();
				num-=idx;
				if(num<=0) {
					num=0;
					deque.addLast(num);
					break;
				}
				deque.addLast(num);
				idx+=1;
				if(idx>5) {
					idx=1;
				}
			}
			sb.append("#").append(T).append(" ");
			for (Integer integer : deque) {
				sb.append(integer).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}