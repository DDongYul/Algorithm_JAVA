import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Lecture l){
            return this.end - l.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s,e);
        }
        Arrays.sort(lectures, new Comparator<Lecture>(){
            @Override
            public int compare(Lecture l1, Lecture l2){
                return l1.start - l2.start;
            }
        });
        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        pq.add(lectures[0]);
        for (int i = 1; i < N; i++) {
            if(lectures[i].start>=pq.peek().end){
                pq.poll();
            }
            pq.add(lectures[i]);
        }
        System.out.println(pq.size());
    }

}