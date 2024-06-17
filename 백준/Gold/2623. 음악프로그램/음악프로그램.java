import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] countLink = new int[N+1];
        List<Integer>[] edges = new List[N+1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> lst = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                lst.add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j <lst.size(); j++) {
                for (int k = j+1; k<lst.size(); k++) {
                    edges[lst.get(j)].add(lst.get(k));
                    countLink[lst.get(k)]+=1;
                }
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(countLink[i] == 0){
                queue.add(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            sb.append(curr).append("\n");
            index++;
            for(Integer node: edges[curr]){
                countLink[node] -=1;
                if(countLink[node]==0){
                    queue.add(node);
                }
            }
        }
        if(index==N) {
            System.out.println(sb);
        }
        else{
            System.out.println(0);
        }
    }

}