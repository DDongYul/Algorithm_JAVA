import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double l = 0;
        double r = Math.min(Math.min(L,W),H);
        while(l<r){
            double mid = (l+r)/2;
//            System.out.println(mid);
            long a = (long) (L/mid);
            long b = (long) (W/mid);
            long c = (long) (H/mid);

            if(a*b*c<N){
                if(r==mid) break;
                r = mid;
            }else{
                if(l==mid) break;
                l = mid;
            }
        }
        System.out.println(l);

    }
}