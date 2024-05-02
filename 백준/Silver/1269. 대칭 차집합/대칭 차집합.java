import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arrA = new int[a];
        int[] arrB = new int[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        List<Integer> lst = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while(p1<a && p2<b){
            if(arrA[p1]==arrB[p2]){
                lst.add(arrA[p1]);
                p1++;
                p2++;
            }
            else if(arrA[p1]>arrB[p2]){
                p2++;
            }
            else{
                p1++;
            }
        }
        System.out.println(a+b-(2*lst.size()));
    }
}