import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean[] visited  = new boolean[1_000_001];
        int[] score  = new int[1_000_001];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> lst = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            pq.add(n);
            lst.add(n);
            visited[n]=true;
        }
        for(Integer curr : pq){
            int cnt = 0;
            for (int i = curr*2; i < 1_000_001; i+=curr) {
                if(visited[i]){
                    cnt+=1;
                }
                score[i]-=1;
            }
            score[curr] +=cnt;
        }

        for(Integer curr : lst){
            sb.append(score[curr]).append(" ");
        }
        System.out.println(sb);
    }
}