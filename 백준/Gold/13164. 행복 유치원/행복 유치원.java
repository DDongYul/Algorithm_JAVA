import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Pair implements Comparable<Pair>{
        int d;
        int idx;

        public Pair(int d, int idx) {
            this.d = d;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p){
            return p.d - this.d;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i==0){
                pq.add(new Pair(0,0));
                continue;
            }
            pq.add(new Pair(arr[i] - arr[i-1],i));
        }
        int cnt = 0;
        boolean[] check = new boolean[N];
        while (cnt<C-1){
            Pair p = pq.poll();
            check[p.idx] = true;
            cnt++;
        }
//        System.out.println(Arrays.toString(check));
        int answer = 0;
        int start = 0; //조의 처음
        for (int i = 1; i < N; i++) {
            if(check[i]){
                answer += arr[i-1] - arr[start];
                start = i;
                continue;
            }
        }
        if(!check[N-1]){
            answer+=arr[N-1] - arr[start];
        }
        System.out.println(answer);
    }

}