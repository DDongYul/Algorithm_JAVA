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
        String pwd = br.readLine();

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while(idx<N){
            int curr = pwd.charAt(idx) - '0';
            //가장 마지막 자릿수에 도착
            if(idx == N-1){
                curr = (curr+M)%10;
                sb.append(curr);
                break;
            }
            //현재 자릿수가 0이면
            if(curr == 0){
                idx+=1;
                sb.append(0);
                continue;
            }
            int need = 10-curr;
            if(need>M){
                idx++;
                sb.append(curr);
                continue;
            }
            M-=need;
            sb.append(0);
            idx++;
        }
        System.out.println(sb);

    }


}