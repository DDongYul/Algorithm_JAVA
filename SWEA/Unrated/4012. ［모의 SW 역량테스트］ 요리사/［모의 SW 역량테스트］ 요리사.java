import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int answer;

    static void combination(int depth, int s){
        if(depth == N/2){
            List<Integer> temp = new ArrayList<>();
            List<Integer> temp2 = new ArrayList<>();
            for (int i = 1; i<=N; i++){
                if(visited[i]){
                    temp.add(i);
                }
                else{
                    temp2.add(i);
                }
            }
            int a = 0;
            int b = 0;
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    a+=arr[temp.get(i)-1][temp.get(j)-1];
                    b+=arr[temp2.get(i)-1][temp2.get(j)-1];
                }
            }
            answer = Math.min(answer,Math.abs(a-b));
            return;
        }
        for(int i = s; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(depth+1, i+1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N+1];
            answer = 10_000_000;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(0,1);
            sb.append("#").append(t+1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

}