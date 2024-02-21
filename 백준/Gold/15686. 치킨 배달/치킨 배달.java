import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 조...합
 */
public class Main {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] arr;
    static List<Point> chicken = new ArrayList<>(); //치킨 집 좌표 리스트
    static List<Point> house = new ArrayList<>();   //일반 집 좌표 리스트
    static boolean[] selected; //선택되는 치킨집
    static int answer = Integer.MAX_VALUE;

    static void sol(int depth, int curr) {
        if (depth == M) {
            int total = 0;
            for (Point house : house) {
                int temp = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (selected[i]) {
                        temp = Math.min(temp, Math.abs(house.x - chicken.get(i).x) + Math.abs(
                            house.y - chicken.get(i).y));
                    }
                }
                total += temp;
            }
            answer = Math.min(answer, total);
            return;
        }
        for (int i = curr+1; i < chicken.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                sol(depth + 1, i);
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    house.add(new Point(i, j));
                }
                if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        selected = new boolean[chicken.size()];
        sol(0,-1);
        System.out.println(answer);
    }

}