import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int d;
        int cost;

        public Node(int d, int cost) {
            this.d = d;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Node>[] graph = new List[V+1];
        for (int i = 1; i <=V; i++) {
            graph[i] = new ArrayList<>();
        }
        PriorityQueue<Node> pq = new PriorityQueue();
        boolean[] visited = new boolean[V+1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,d));
            graph[b].add(new Node(a,d));
        }
        int answer = 0;
        visited[1] = true;
        for (Node node : graph[1]){
            pq.add(node);
        }
        while (!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.d]){
                continue;
            }
            answer+=node.cost;
            visited[node.d]=true;
            for (Node n : graph[node.d]){
                pq.add(n);
            }
        }
        System.out.println(answer);
    }

}