import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void BFS(Point start, char op, char[][] arr, boolean[][] visited) {
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start.x][start.y] = true;
        while (!deque.isEmpty()) {
            Point curr = deque.removeFirst();
            int x = curr.x;
            int y = curr.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]
                    && arr[nx][ny] == op) {
                    visited[nx][ny] = true;
                    deque.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][N];
        char[][] arr2 = new char[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
                if (str.charAt(j) == 'G') {
                    arr2[i][j] = 'R';
                } else {
                    arr2[i][j] = str.charAt(j);
                }
            }
        }

        int answer1 = 0;
        int answer2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    BFS(new Point(i, j), arr[i][j], arr,visited);
                    answer1 += 1;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    BFS(new Point(i, j), arr2[i][j], arr2,visited);
                    answer2 += 1;
                }
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}