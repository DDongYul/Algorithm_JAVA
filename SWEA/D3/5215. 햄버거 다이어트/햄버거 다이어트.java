import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int L;
    static int[] score;
    static int[] cal;
    static int answer;

    //s: 현재 스코어 , c: 현재 칼로리
    static void search(int depth, int s, int c, int next) {
        if(c>L){
            return;
        }
        if (depth >= N) {
            answer = Math.max(answer, s);
            return;
        }
        answer = Math.max(answer, s);
        for (int i = next; i < N; i++) {
            search(depth+1, s+score[i],c+cal[i], i+1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            score = new int[N];
            cal = new int[N];
            answer = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            search(0,0,0, 0);
            sb.append("#").append(t + 1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }

}