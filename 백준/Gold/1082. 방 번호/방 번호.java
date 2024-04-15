import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 비용이 작은 수로 채워놓고 시작
 * 그것보다 큰 수로 교체할 수 있는지 체크, 가능하면 바꿔주고 불가능하면 자릿수 긴게 가장 큰 수이므로 정답
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N];
        int min = 51;
        int minIndex = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            //같을 때는 큰 값으로 먼저 채우게 = 넣어주기
            if(cost[i]<=min){
                min = cost[i];
                minIndex = i;
            }
        }
        int M = Integer.parseInt(br.readLine());

        int[] answer = new int[51];
        int l = 0;
        while (M>0){
            M-=min;
            if(M<0){
                M+=min; //남은 돈 처리
                break;
            }
            answer[l] = minIndex;
            l++;
        }

        boolean flag_zero = false;

        for (int i = l-1; i >= 0; i--) {
            M+=min;
            boolean flag = false;   //자릿 수 바꾼 경우
            for (int j = N-1; j >minIndex; j--) {
                if(M>=cost[j]){
                    answer[i] = j;
                    M-=cost[j];
                    flag = true;
                    flag_zero = true;
                    break;
                }
            }
            //맨 끝 자리가 0이면..
            if(answer[i] == 0 && !flag_zero){
                continue;
            }
            //자릿 수 바꾼 경우
            if(flag){
                continue;
            }
            else {
                break;
            }
        }

        boolean flag = false;
        for (int i = 50; i >=0; i--) {
            if(answer[i]!=0) flag = true;

            if(flag){
                sb.append(answer[i]);
            }
        }
        if(sb.toString().length()==0){
            System.out.println(0);
        }
        else {
            System.out.println(sb);
        }
    }
}