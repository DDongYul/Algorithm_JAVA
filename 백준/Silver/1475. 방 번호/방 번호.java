import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String N = br.readLine();
        int[] arr = new int[9];
        for (int i = 0; i < N.length(); i++) {
            int num = Character.getNumericValue(N.charAt(i));
            if(num == 9){
                arr[6] +=1;
            }
            else{
                arr[num]+=1;
            }
        }
        int answer = 0;
        for (int i = 0; i < 9; i++) {
            if(i == 6){
                answer = Math.max(answer, arr[6]/2 + arr[6]%2);
            }
            else{
                answer = Math.max(answer, arr[i]);
            }
        }
        System.out.println(answer);
    }

}