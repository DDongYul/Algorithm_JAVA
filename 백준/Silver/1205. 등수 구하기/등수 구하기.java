import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N>0) {
            st = new StringTokenizer(br.readLine());
        }
        int answer = 1;
        int temp = 0;
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            if(score>S){
                answer+=1;
            }else if(score == S){
                temp+=1;
            }else{
                break;
            }
        }
        if(answer+temp<=P){
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }
    }
}