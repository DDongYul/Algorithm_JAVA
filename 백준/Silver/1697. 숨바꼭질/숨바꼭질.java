import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int N,K;
    private static int[] board = new int[200001];
    private static boolean[] visited = new boolean[200001];

    private static int BFS(){
        visited[N] = true;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{N,0});
        while(!deque.isEmpty()){
            int[] curr = deque.poll();
            int x = curr[0];
            int t = curr[1];
            if(x==K){
                return t;
            }
            for(int dx : new int[] {-1,1}){
                if(x+dx>=0 && x+dx<200001 && !visited[x+dx]){
                    deque.add(new int[]{x+dx,t+1});
                    visited[x+dx] = true;
                }
            }
            if(x*2>=0 && x*2<200001&& !visited[x*2]){
                deque.add(new int[]{x*2,t+1});
                visited[x*2] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(BFS());
    }

}