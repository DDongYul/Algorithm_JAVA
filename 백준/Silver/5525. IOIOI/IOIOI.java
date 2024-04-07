import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] hash = new int[M];
        int idx = 0;
        for(int i = 0; i<str.length(); i++){
            if (str.charAt(i) == 'I') {
                hash[idx++] = i;
            }
        }

        int cnt = 0;
        int answer = 0;
        for(int i = 1; i<hash.length; i++){
            if(hash[i] - hash[i-1] == 2){
                cnt+=1;
            }
            else{
                cnt = 0;
            }
            if(cnt>=N){
                answer+=1;
            }
        }
        System.out.println(answer);
    }

}