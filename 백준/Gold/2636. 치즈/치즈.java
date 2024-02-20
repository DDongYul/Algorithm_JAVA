import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] arr;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static List<Point> starts;
    static int[][] visited;

    static int BFS() {
        int cnt = 0;
        Deque<Point> deque = new ArrayDeque<>();
        for (Point start : starts) {
            deque.add(start);
            visited[start.x][start.y] = 1;
        }
        starts.clear();
        while (!deque.isEmpty()) {
            Point curr = deque.removeFirst();
            int x = curr.x;
            int y = curr.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && visited[nx][ny]==0) {
                    if(arr[nx][ny] == 1){
                        visited[nx][ny] = 2;
                        starts.add(new Point(nx, ny));
                        cnt+=1;
                        continue;
                    }
                    visited[nx][ny] = 1;
                    deque.add(new Point(nx, ny));
                }
            }
        }
        return cnt;
    }

    static boolean isFinished() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N][M];
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        starts = new ArrayList<>();
        starts.add(new Point(0,0));
        starts.add(new Point(0,M-1));
        starts.add(new Point(N-1,0));
        starts.add(new Point(N-1,M-1));

        int answer = 0;
        int temp = 0;
        int temp2 = 0;
        while (!isFinished()) {
            temp = BFS();
            if(temp == 0){
                temp = temp2;
                break;
            }
            answer+=1;
            temp2 = temp;
        }
        System.out.println(answer);
        System.out.println(temp);
    }

}