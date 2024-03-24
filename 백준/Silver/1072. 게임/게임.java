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
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long start = y;
        long end = 2_000_000_000;
        long des = (y*100)/x;
        long answer = -1;

        while(start<=end){
            long mid = (end+start)/2;
            long curr = (mid*100)/(x+(mid-y));
            if(curr>des){
                answer = mid-y;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        System.out.println(answer);
    }

}