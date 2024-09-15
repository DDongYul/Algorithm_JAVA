import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 인접한 두 공유기 사이 최대 거리를 기준으로 탐색.
 * 1 2 4 8 9
 *
 */
public class Main {

    public static boolean check(int n,int c, int[] arr){
        int curr = arr[0];
        int need = curr+n;
        int cnt = c-1;
        int idx = 1;
        while (idx<arr.length){
            int num = arr[idx];
            if(num<need){
                idx++;
                continue;
            }
            need = num+n;
            cnt-=1;
            idx++;
        }
        if(cnt<=0){
            return true;
        }return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr[N-1]+1;
        while (left<=right){
            int mid = (left+right)/2;
            if(check(mid,C,arr)){
                left = mid+1;
            }else{
                right = mid-1;
            }
//            System.out.println("mid: " + mid);
//            System.out.println("left: " + left);
//            System.out.println("right: " + right);
//            System.out.println("===================");
        }
        System.out.println(right);
    }

}