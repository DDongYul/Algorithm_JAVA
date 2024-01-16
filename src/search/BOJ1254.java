package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1254 {

    public static Boolean pal(String str) {
        int p1 = 0;
        int p2 = str.length()-1;
        while(p1<p2) {
            if(str.charAt(p1)!=str.charAt(p2)) {
                return false;
            }
            p1+=1;
            p2-=1;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        //앞에서부터 문자열 자르면서 펠린드롬이 나타나면 그만큼 더해주면 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Boolean flag = false;
        int idx = 0;
        while(!flag) {
            flag = pal(str.substring(idx));
            if(flag) {
                break;
            }
            idx+=1;
        }
        System.out.println(str.length()+idx);
    }
}
