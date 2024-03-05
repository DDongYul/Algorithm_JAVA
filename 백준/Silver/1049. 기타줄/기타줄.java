import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int price1=1001;
        int price2=1001;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            price1 = Math.min(price1, Integer.parseInt(st.nextToken()));
            price2 = Math.min(price2, Integer.parseInt(st.nextToken()));
        }

        if(price2*6<price1){
            System.out.println(price2*N);
            return;
        }

        int total = price1*(N/6);
        total += Math.min(N%6 * price2, price1);
        System.out.println(total);
    }
}