import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long[] arr = new long[N + 1];
            long[] s = new long[N + 1];
            long sum = 0;

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            s[1] = arr[1];

            for (int i = 2; i <= N; i++) {
                s[i] = s[i - 1] + arr[i];
            }
            long minVal;
                for (int i = 2; i <= N; i++) {
                    minVal = Long.MAX_VALUE;
                    for (int j = i; j <= N; j++) {
                        minVal = Math.min(minVal,
                            arr[j] * i - (s[j] - s[j - i]));
                    }
                    sum += minVal;
                }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}