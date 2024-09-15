import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    public static int find(int x){
        while (parents[x] != x){
            x = parents[x];
        }
        return x;
    }

    public static void union(int a, int b){
        if(a>b){
            int temp = a;
            a = b;
            b = temp;
        }
        parents[find(b)] = find(a);
    }

    public static boolean in(List<Integer> lst, int x){
        for (int i = 0; i < lst.size(); i++) {
            if(x==lst.get(i)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int trueNum = Integer.parseInt(st.nextToken());
        boolean[] trueArr = new boolean[N+1];
        for (int i = 0; i < trueNum; i++) {
            trueArr[Integer.parseInt(st.nextToken())] = true;
        }
        parents = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parents[i] = i;
        }
        List[] party = new List[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            party[i].add(x);
            for(int j=0; j<n-1; j++){
                int y = Integer.parseInt(st.nextToken());
                party[i].add(y);
                union(x,y);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (trueArr[i]){
                trueArr[find(i)] = true;
            }
        }

//        System.out.println(Arrays.toString(parents));
//        System.out.println(Arrays.toString(trueArr));

        int answer = 0;
        for (List<Integer> lst : party){
            boolean flag = true;
            for(Integer i : lst){
                if(trueArr[find(i)]){
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer++;
        }
        System.out.println(answer);
    }

}