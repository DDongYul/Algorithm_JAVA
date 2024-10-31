import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i];
        }

        long mx = 0;
        int idx = 1;
        int answer = 0;
        while(mx<=b && idx<=n){
            if(idx<=a){
                mx = arr[idx]/2;
            }else{
                mx = arr[idx-a] + (arr[idx]-arr[idx-a])/2;
            }
            if(mx>b){
                break;
            }else{
                idx++;
            }
        }
        answer = idx-1;
        System.out.println(answer);
    }

}