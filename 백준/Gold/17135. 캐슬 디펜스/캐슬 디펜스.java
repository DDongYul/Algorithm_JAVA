import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    /**
     * 조합으로 모든 경우 해보기 항상 왼쪽 궁수부터 BFS 시작 탐색도 왼쪽부터, 사거리 끝나면 탐색 종료
     */
    static class Point {
        int x;
        int y;
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }



    static int N,M,D;
    static int[][] arr;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};   //아래 방향은 제외
    static int cnt;

    static Point BFS(Point start) {
        Deque<Point> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        deque.add(start);
        while (!deque.isEmpty()) {
            Point curr = deque.removeFirst();
            int x = curr.x;
            int y = curr.y;
            int d = curr.d;
            for (int i = 0; i < 3; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                int nd = d+1;
                if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && nd<=D){
                    if(arr[nx][ny] == 1){
                        return new Point(nx,ny,0);
                    }
                    visited[nx][ny] = true;
                    deque.add(new Point(nx,ny,nd));
                }
            }
        }
        return start;
    }

    static void round() {
        for (int i = N-1; i >0; i--) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = arr[i-1][j];
            }
        }

        for (int i = 0; i < M; i++) {
            arr[0][i] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = arr[i][j];
            }
        }

        //조합으로 다 해보기
        int answer = 0;
        cnt = 0;

            for (int i = 0; i < M - 2; i++) {
                for (int j = i + 1; j < M - 1; j++) {
                    for (int k = j + 1; k < M; k++) {
                        for (int h = 0; h < N; h++) {
                            for (int g = 0; g < M; g++) {
                                arr[h][g] = temp[h][g];
                            }
                        }
                        for (int r = 0; r < N; r++) {
                            Point p1 = BFS(new Point(N, i, 0));
                            Point p2 = BFS(new Point(N, j, 0));
                            Point p3 = BFS(new Point(N, k, 0));
                            if(arr[p1.x][p1.y] ==1) {
                                arr[p1.x][p1.y] = 0;
                                cnt+=1;
                            }
                            if(arr[p2.x][p2.y] ==1) {
                                arr[p2.x][p2.y] = 0;
                                cnt+=1;
                            }
                            if(arr[p3.x][p3.y] ==1) {
                                arr[p3.x][p3.y] = 0;
                                cnt+=1;
                            }
                            round();
                        }
                        answer = Math.max(answer,cnt);
                        cnt = 0;
                    }
                }
            }

        System.out.println(answer);
    }
}