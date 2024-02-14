import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static char[][] arr;

    //모두 같으면
    static boolean check(int n, int x, int y) {
        char curr = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != curr) {
                    return false;
                }
            }
        }
        return true;
    }

    static void solution(int n, int x, int y) {
        if (n == 1) {
            sb.append(arr[x][y]);
            return;
        }

        n = n / 2;

        if (check(n, x, y)) {
            sb.append(arr[x][y]);
        } else {
            sb.append("(");
            solution(n, x, y);
            sb.append(")");
        }

        if (check(n, x, y + n)) {
            sb.append(arr[x][y + n]);
        } else {
            sb.append("(");
            solution(n, x, y + n);
            sb.append(")");
        }

        if (check(n, x + n, y)) {
            sb.append(arr[x + n][y]);
        }else {
            sb.append("(");
            solution(n, x + n, y);
            sb.append(")");
        }

        if (check(n, x + n, y + n)) {
            sb.append(arr[x + n][y + n]);
        }else{
            sb.append("(");
            solution(n, x + n, y + n);
            sb.append(")");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        if (check(N, 0, 0)) {
            System.out.println(arr[0][0]);
            System.exit(0);
        }
        sb.append("(");
        solution(N, 0, 0);
        sb.append(")");
        System.out.println(sb);
    }

}