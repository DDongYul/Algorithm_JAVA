import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] p = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int max = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int curr = p[i][0]; //두 값 사이의 값은 탐색할 필요 없음
            int sum= 0; //배송비 1원이라도 넘으면 안 팜
            if((curr - p[i][1])>0){
                sum = curr - p[i][1];
            }
            for (int j = i+1; j < N; j++) {
                if((curr-p[j][1]) > 0){
                    sum+= (curr-p[j][1]);
                }
            }
            if(sum>max){
                max = sum;
                answer = curr;
            }
        }
        System.out.println(answer);
    }
}
