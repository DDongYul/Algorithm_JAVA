import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static Point[] points;
    static int answer;
    static boolean[] visited;
    static Point house;
    static Point company;

    static void solution(int depth, int cnt, Point curr) {
        if (depth == N) {
            int d = Math.abs(curr.x - house.x) + Math.abs(curr.y - house.y);
            answer = Math.min(answer, cnt+d);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                Point next = points[i];
                int d = Math.abs(curr.x - next.x) + Math.abs(curr.y - next.y);
                visited[i] = true;
                solution(depth + 1, cnt+d, points[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //input
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            points = new Point[N];
            visited = new boolean[N];
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            company = new Point( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            house = new Point( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }

            solution(0,0,company);
            sb.append("#").append(t + 1).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }

}