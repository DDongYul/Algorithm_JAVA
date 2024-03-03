import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Node implements Comparable<Node>{
        int start;
        int end;
        int comIdx;
        int cnt;

        public Node(int start, int end, int comIdx, int cnt) {
            this.start = start;
            this.end = end;
            this.comIdx = comIdx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.start - o.start;
        }
    }

    private static class ComList implements Comparable<ComList> {
        int idx;
        int cnt;

        public ComList(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(ComList o) {
            return this.idx - o.idx;
        }
    }

    /**
     * 최소힙에 (시작시간, 끝 시간, 컴퓨터 번호, 사용 횟수) 전부 넣고 시작
     * 시작인 경우는 컴퓨터 번호 -1, 컴퓨터 넣어놓는 최소 힙에서 꺼내서 (끝 시간, -1, 번호, 횟수) 넣어줌, 없으면 만들어서
     * 끝인 경우는 끝 시간이 -1, 컴퓨터 힙에 (번호, 사용횟수) 넣어줌
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<ComList> computerList = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Node(s,e,-1,-1));
        }
        int idx = 0;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            //시작인 경우
            if(curr.comIdx == -1){
                if(computerList.isEmpty()){
                    pq.add(new Node(curr.end,-1,idx++,1));
                }
                else{
                    ComList com = computerList.poll();
                    pq.add(new Node(curr.end,-1,com.idx,com.cnt+1));
                }
            }
            //끝인 경우
            else if(curr.end == -1){
                computerList.add(new ComList(curr.comIdx,curr.cnt));
            }
        }
        int answer = computerList.size();
        int[] arr = new int[answer];
        for (ComList comList : computerList) {
            arr[comList.idx] = comList.cnt;
        }
        sb.append(answer).append("\n");
        for (int i = 0; i < answer; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

    }

}