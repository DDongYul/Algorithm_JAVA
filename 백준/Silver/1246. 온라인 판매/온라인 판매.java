import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer =  0;
        int price = 0;
        for (int i = 0; i < M; i++) {
            int curr = arr[i];
            int cnt = N>=M-i ? M-i : N;
            if(curr*cnt>answer){
                answer = curr*cnt;
                price = curr;
            }
            answer = Math.max(answer,curr*cnt);
        }
        System.out.println(price + " " + answer);
    }
}