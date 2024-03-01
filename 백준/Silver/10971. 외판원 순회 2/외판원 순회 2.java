import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer,start;
    static int[][] arr;
    static boolean[] visited;

    static void sol(int depth, int cnt, int curr){
        if (depth == N) {
            if(arr[curr][start] == 0){
                return;
            }
            cnt+=arr[curr][start];
            answer = Math.min(answer, cnt);
            return;
        }
        if (cnt > answer) {
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                if(arr[curr][i] == 0){
                    continue;
                }
                visited[i] = true;
                sol(depth+1,cnt+arr[curr][i], i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            start = i;
            sol(1,0,i);
            visited[i] = false;
        }
        System.out.println(answer);
    }

}