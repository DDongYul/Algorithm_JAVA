import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int N;
    static StringBuilder sb;

    static void comb(int start, int depth, int[] result) {
        if (depth == 6) {  // 6개의 숫자를 모두 선택했을 때 출력
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {  // start부터 숫자를 선택
            result[depth] = arr[i];
            comb(i + 1, depth + 1, result);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;  // 입력이 0이면 종료
            arr = new int[N];
            sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0, new int[6]);  // 조합 생성 시작
            sb.append("\n");
            System.out.print(sb);
        }
    }

}