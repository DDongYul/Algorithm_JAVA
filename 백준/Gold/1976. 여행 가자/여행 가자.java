import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int find(int x) {
        while(x!=parent[x]) {
            x = parent[x];
        }
        return x;
    }
    static void union(int a, int b){
        if(a>b) {
            parent[a] = b;
        }
        else {
            parent[b] = a;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i = 0; i<=N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    union(find(i), find(j));
                }
            }
        }


        st = new StringTokenizer(br.readLine());
        int curr =Integer.parseInt(st.nextToken());
        for (int i = 0; i < M - 1; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (find(curr) != find(next)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}