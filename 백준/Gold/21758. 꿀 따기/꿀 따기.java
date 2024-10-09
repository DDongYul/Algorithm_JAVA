import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] sum = new int[N];
        int[] sum2 = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i==0){
                sum[0] = arr[0];
                continue;
            }
            if(i!=0){
                sum[i] = sum[i-1] + arr[i];
            }
        }
        sum2[N-1] = arr[N-1];
        for (int i = N-2; i >=0; i--) {
            sum2[i] = sum2[i+1] + arr[i];
        }

        int max = 0;

        //정방향
        for(int i = 1; i<N-1; i++){
            max = Math.max(max, sum[i-1] + sum[N-2] - arr[i]);
        }


        //역순
        for(int i = N-2; i>0; i--){
            max = Math.max(max, sum2[i+1] + sum2[1] - arr[i]);
        }

        //가운데
        for (int i= 1; i < N-1; i++) {
            max = Math.max(max,(sum[i]- arr[0]+sum2[i] - arr[N-1]));
        }

        System.out.println(max);
    }

}