import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    private static int N,M,L;
    private static List<Integer> lst;

    private static boolean check(int num){
        int idx = 0;
        int cnt = 0;
        int curr = 0;
//        System.out.println("num = " + num);
        while (idx<N+1 && curr<=L){
//            System.out.println("curr = " + curr);
            int next = lst.get(idx+1);
            if(next - curr > num){
                curr = curr+num;
                cnt++;
            }else {
                curr = next;
                idx++;
            }
        }
        if(cnt<=M){
            return true;
        }
        return false;
    }

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
//        int size = N+M;
        lst = new ArrayList<>();
        lst.add(0);
        lst.add(L);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lst.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(lst);
        int left = 0;
        int right = L+1;
        while (left+1<right){
            int mid = (left+right)/2;
            if(check(mid)){
                right = mid;
            }else{
                left = mid;
            }
        }
        System.out.println(right);
    }

}