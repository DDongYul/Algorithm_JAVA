import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 조...합
 */
public class Main {

    static int N, M;
    static int[][] arr;
    static List<Point> chicken;
    static List<Point> house;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Point{
        int x;
        int y;
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int BFS(Point start) {
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(start);
        boolean[][] visited = new boolean[N][N];
        visited[start.x][start.y] = true;
        while (!deque.isEmpty()) {
            Point curr = deque.removeFirst();
            int x = curr.x;
            int y = curr.y;
            int d = curr.d;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    if(arr[nx][ny] == 2) {
                        return d+1;
                    }
                    visited[nx][ny] = true;
                    deque.add(new Point(nx, ny, d+1));
                }
            }
        }
        return 0;
    }

    static void sol(int depth, int curr) {
        if(depth == M){
            int sum = 0;
            for (Point point : house) {
                sum += BFS(point);
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = curr+1; i < chicken.size(); i++) {
            arr[chicken.get(i).x][chicken.get(i).y] = 2;
            sol(depth + 1, i);
            arr[chicken.get(i).x][chicken.get(i).y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chicken = new ArrayList<>();
        house = new ArrayList<>();

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    house.add(new Point(i, j,0));
                }
                if(arr[i][j] == 2){
                    chicken.add(new Point(i, j,0));
                    arr[i][j] = 0;
                }
            }
        }

        sol(0,-1);
        System.out.println(answer);
    }

}