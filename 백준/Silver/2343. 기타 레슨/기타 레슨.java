import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left,arr[i]);
            right+=arr[i];
        }
        left-=1;
        right+=1;
        while (left + 1 < right) {
            int mid = (left+right) / 2;
            int cnt = 0;
            int sum = 0;;
            for (int i = 0; i < N; i++) {
                if(sum+arr[i]>mid){
                    cnt+=1;
                    sum = arr[i];
                    continue;
                }
                sum+=arr[i];
            }
            if(sum!=0){
                cnt++;
            }
            if(cnt > M){
                left = mid;
            }else{
                right = mid;
            }
        }
        System.out.println(right);
    }

}