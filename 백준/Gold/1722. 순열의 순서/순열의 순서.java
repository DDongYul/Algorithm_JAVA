import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long idx;
    static boolean[] visited;
    static int[] arr;

    static long fact(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static void sol1(long num){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long curr = fact(N-1-i);
            int idx = (int) (num/curr);
            num%=curr;
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if(visited[j]) continue;
                if(temp == idx){
                    temp = j;
                    break;
                }
                temp++;
            }
            sb.append(temp+1).append(" ");
            visited[temp] = true;
        }
        System.out.println(sb);
    }

    static long sol2(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }
        long answer = 1;
        for (int i = 0; i < N; i++) {
            int index = numbers.indexOf(arr[i]);
            answer += index * fact(N - 1 - i);
            numbers.remove(index);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        if(num == 1){
            idx = Long.parseLong(st.nextToken());
            sol1(idx-1);
        }

        if(num == 2){
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(sol2());
        }

    }

}