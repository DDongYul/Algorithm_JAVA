import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Pair implements Comparable<Pair> {

		long x1;
		long x2;
		int idx;

		public Pair(long x1, long x2) {
			this.x1 = x1;
			this.x2 = x2;
		}

		public Pair() {

		}

		@Override
		public int compareTo(Pair o) {
			return Long.compare(this.x1, o.x1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		long prevX = Integer.parseInt(st.nextToken());
		long prevY = Integer.parseInt(st.nextToken());
		List<Pair> lst = new ArrayList<>();
		Stack<Pair> stack = new Stack<>();
		boolean visit[] = new boolean[1000000];

		int idx = 0;

		long startX = prevX;
		long startY = prevY;

		for (int i = 1; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			long currX = Integer.parseInt(st.nextToken());
			long currY = Integer.parseInt(st.nextToken());

//			if (i == N - 1 && !stack.isEmpty()) {
//				Pair curr = stack.pop();
//				if (curr.x1 > currX) {
//					curr.x2 = curr.x1;
//					curr.x1 = currX;
//				} else {
//					curr.x2 = currX;
//				}
//				curr.idx = idx++;
//				lst.add(curr);
//			}
			// 세로일 때
			if (prevY != currY) {
				if (prevY > 0 && currY < 0) {
					if (!stack.isEmpty()) {
						Pair curr = stack.pop();
						if (curr.x1 > currX) {
							curr.x2 = curr.x1;
							curr.x1 = currX;
						} else {
							curr.x2 = currX;
						}
						curr.idx = idx++;
						lst.add(curr);
					} else {
						Pair point = new Pair(currX, 0);
						stack.add(point);
					}
				} else if (prevY < 0 && currY > 0) {
					Pair point = new Pair(currX, 0);
					stack.add(point);
				}
				prevY = currY;
			}
			// 가로일 때
			else {
				prevX = currX;
			}
		}

		if(stack.size()==1) {
			Pair po1 = stack.pop();
			po1.x2 = startX;
			long temp = po1.x2;
			if (po1.x1 > po1.x2) {
				po1.x2 = po1.x1;
				po1.x1 = temp;
			}
			po1.idx = idx++;
			lst.add(po1);
		}
		else if (stack.size() == 2) {
			Pair po1 = stack.pop();
			Pair po2 = stack.pop();
			po1.x2 = po2.x1;
			long temp = po1.x2;
			if (po1.x1 > po1.x2) {
				po1.x2 = po1.x1;
				po1.x1 = temp;
			}
			po1.idx = idx++;
			lst.add(po1);
		}

		Collections.sort(lst);

//		for (Pair point : lst) {
//			System.out.println("x1: " + point.x1 + " x2: " + point.x2);
//		}

//        long p1 = lst.get(0).x2;
//        long p2 = lst.get(0).x2;
//        long answer1 = 1;
//        long answer2 = 1;
//        
//        for (int i = 1; i < lst.size(); i++) {
//            if (lst.get(i).x1 > p1) {
//                p1 = lst.get(i).x2;
//                answer1 += 1;
//            }
//            if (lst.get(i).x1 > p2) {
//                answer2 += 1;
//            }
//            p2 = lst.get(i).x2;
//        }

		Stack<Pair> stack2 = new Stack<>();

		long answer1 = 0;
		long answer2 = 0;

		for (Pair p : lst) {

			while (!stack2.isEmpty() && p.x1 > stack2.peek().x2) {
				if (!visit[stack2.peek().idx])
					answer2++;
				stack2.pop();
			}

			if (stack2.isEmpty()) {
				answer1++;
				stack2.add(p);
			} else {
				visit[stack2.peek().idx] = true;
				stack2.add(p);
			}
		}

		while (!stack2.isEmpty()) {
			if (!visit[stack2.peek().idx])
				answer2++;
			stack2.pop();
		}

		System.out.println(answer1 + " " + answer2);
	}
}