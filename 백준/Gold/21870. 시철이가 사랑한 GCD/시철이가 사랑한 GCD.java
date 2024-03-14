import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //왼쪽 버림 오른쪽 올림
    //둘 중 gcd 최대값인 것 선택이 아닌... 왼쪽 전부, 오른쪽 전부 본 다음 최대 값 골라야함
    //백트래킹 필요...
    //최대공약수 구하는 알고리즘

    static int answer;
    static int[] arr;

    private static int gcd(int x, int y) {
        if(x<y){
            int temp = y;
            y = x;
            x = temp;
        }
        if(x%y == 0){
            return y;
        }
        else{
            return gcd(y,x%y);
        }
    }

    private static int gcdAll(int start, int end){
        int gcd = arr[start];

        for (int i = start + 1; i < end; i++){
            gcd = gcd(gcd, arr[i]);
            if(gcd == 1){
                break;
            }
        }
        return gcd;
    }


    private static void sol(int start, int end, int sum){
        if (start >= end - 1){
            answer = Math.max(answer, sum + arr[start]);
            return;
        }

        int m = (start + end) / 2;
        sol(start, m, sum + gcdAll(m, end)); //오른쪽 반 선택
        sol(m, end, sum + gcdAll(start, m)); //왼쪽 반 선택
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol(0,N,0);
        System.out.println(answer);
    }

}