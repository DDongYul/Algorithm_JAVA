import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Input{
        int p;
        int l;
        int r;

        public Input(int p, int l, int r) {
            this.p = p;
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] right = new int[N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            right[P] = R;
        }
        int curr = 1;
        int cnt = -1;
        while (curr != -1) {
            curr = right[curr];
            cnt += 1;
        }
        System.out.println((N-1)*2-cnt);
    }
}