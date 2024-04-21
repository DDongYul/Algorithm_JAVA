import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(i, name);
            map2.put(name,i);
        }
        for (int i = 0; i < M; i++) {
            String ipt = br.readLine();
            if(65<=ipt.charAt(0) && ipt.charAt(0)<=122) {
                sb.append(map2.get(ipt)).append("\n");
            }else {
                sb.append(map.get(Integer.parseInt(ipt))).append("\n");
            }
        }
        System.out.println(sb);

    }
}