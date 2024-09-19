import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {


    static int n,m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int[][] board;

    public static int BFS(int sx,int sy){
        int cnt = 0;
        Deque<int[]> deque = new ArrayDeque();
        deque.add(new int[]{sx,sy});
        visited[sx][sy] = true;
        while (!deque.isEmpty()) {
            cnt++;
            int[] point = deque.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && board[nx][ny]==1){
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx,ny});
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 0;
        int max = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && board[i][j] == 1){
                    num+=1;
                    max = Math.max(max,BFS(i,j));
                }
            }
        }
        System.out.println(num);
        System.out.println(max);
    }


}