import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    static class Pair implements Comparable<Pair>{

        int d;
        int w;

        public Pair(int d, int w) {
            this.d = d;
            this.w = w;
        }

        public int compareTo(Pair p){
            return p.w - this.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Pair(d,w));
        }
        int[] arr = new int[1001];
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            for(int i = p.d; i>0; i--){
                if(arr[i] <p.w){
                    arr[i] = p.w;
                    break;
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < 1001; i++) {
            answer+=arr[i];
        }
        System.out.println(answer);



    }
}