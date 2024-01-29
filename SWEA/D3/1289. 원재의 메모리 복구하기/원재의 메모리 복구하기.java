import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i ++) {
            String str = br.readLine(); // 원래 문자
            char curr = '0';
            int cnt = 0;
            for(int j = 0; j<str.length(); j++) {
                if(str.charAt(j) != curr) {
                    cnt+=1;
                    curr = str.charAt(j);
                }
            }
            System.out.println("#" + (i+1) + " " + cnt);
        }
         
    }
}