import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            List<Character> lst = new ArrayList<>();
            String str = br.readLine();
            char curr = str.charAt(0);
            lst.add(curr);
            Boolean flag = true;
            for (int j = 1; j < str.length(); j++) {
                if(str.charAt(j)!=curr&&lst.contains(str.charAt(j))){
                    flag=false;
                    break;
                }else{
                    curr = str.charAt(j);
                    lst.add(str.charAt(j));
                }
            }
            if(flag){
                answer+=1;
            }
        }
        System.out.println(answer);
    }
}