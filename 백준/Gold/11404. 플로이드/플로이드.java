import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int INF = 100000001;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] cost = new int[N+1][N+1];
        for (int i = 1; i <=N; i++) {
            for(int j = 1; j<=N; j++){
                cost[i][j] = INF;
                if(i == j){
                    cost[i][j] = 0;
                }
            }
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[s][e] = Math.min(cost[s][e],c);
        }

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                for(int k = 1; k<=N; k++){
                    cost[j][k] = Math.min(cost[j][i] + cost[i][k] , cost[j][k]);
                }
            }
        }
        for(int i = 1; i<=N; i++){
            for (int j = 1; j <=N ; j++) {
                if(cost[i][j] == INF){
                    sb.append(0).append(" ");
                }
                else {
                    sb.append(cost[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}