import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] children = new List[N+1];
        for (int i = 0; i < N + 1; i++) {
            children[i] = new ArrayList<>();
        }
        int[] cost = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            children[a].add(b);
            cost[b]+=1;
        }

        Deque<Integer> lst = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (cost[i] == 0) {
                lst.add(i);
            }
        }
        while (!lst.isEmpty()){
            int curr = lst.removeFirst();
            sb.append(curr + " ");
            for (Integer child : children[curr]) {
                cost[child]-=1;
                if (cost[child] == 0) {
                    lst.add(child);
                }
            }
        }
        System.out.println(sb);
    }

}