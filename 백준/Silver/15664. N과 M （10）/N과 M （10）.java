import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static int N,M;
    private static int[] arr;
    private static StringBuilder answer;
    private static boolean[] visited;
    private static Map<String, Integer> map;

    private static void comb(int depth, int prev){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if(visited[i]){
                    sb.append(arr[i]).append(" ");
                }
            }
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(), 1);
                answer.append(sb).append("\n");
            }
        }
        for (int i = prev+1; i <N; i++) {
            visited[i] = true;
            comb(depth+1, i);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        answer = new StringBuilder();
        map = new HashMap<>();
        visited = new boolean[N];
        comb(0, -1);
        System.out.println(answer);
    }

}