import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static class Node{
        int index;
        List<Edge> edge; //해당 정점과 연결된 간선

        public Node(int index) {
            this.index = index;
            edge = new ArrayList<Edge>();
        }
    }

    static class Edge{
        int end;	//간선의 도착지점
        long cost;	//간선의 비용

        public Edge(int end, long cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        long[] dx = new long[1000];
        long[] dy = new long[1000];
        Node[] nodes = new Node[1000];

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            //input
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                dx[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                dy[i] = Long.parseLong(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine());

            //정점 초기화
            for (int i = 0; i < N; i++) {
                nodes[i] = new Node(i);
            }

            //간선 넣어주기
            for (int i = 0; i < N; i++) {
                for (int j = i; j < N; j++) {
                    long distX = Math.abs(dx[i]-dx[j]);
                    long distY = Math.abs(dy[i]-dy[j]);
                    long cost = (distX * distX) + (distY * distY);
                    nodes[i].edge.add(new Edge(j,cost));
                    nodes[j].edge.add(new Edge(i,cost));
                }
            }


            PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
                @Override
                public int compare(Edge e1, Edge e2) {
                    return Long.compare(e1.cost,e2.cost);
                }
            });

            //첫번 째 정점 간선 넣고 시작
            for (Edge edge : nodes[0].edge) {
                pq.add(edge);
            }

            //prim
            boolean[] visited = new boolean[N];
            visited[0] = true;
            int cnt = 1;
            long answer = 0;

            while (cnt<N) {
                Edge curr = pq.poll();
                if (!visited[curr.end]) {
                    for (Edge edge : nodes[curr.end].edge) {
                        pq.add(edge);
                    }
                    answer += curr.cost;
                    visited[curr.end] = true;
                    cnt+=1;
                }
            }
            sb.append("#").append(t+1).append(" ").append(Math.round(answer*E)).append("\n");
        }
        System.out.println(sb);
    }

}