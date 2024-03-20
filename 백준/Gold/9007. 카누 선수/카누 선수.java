import java.io.*;
import java.util.*;

public class Main {

    private static int[] mix(int[] arr1, int[] arr2){
        int[] ret = new int[arr1.length * arr2.length];
        int idx = 0;

        for (int n1 : arr1) {
            for (int n2 : arr2) {
                ret[idx++] = n1 + n2;
            }
        }
        return ret;
    }

    private static int binarySearch(int[] arr, int key){
        int idx = Arrays.binarySearch(arr, key);
        return (idx < 0) ? - idx - 1 : idx;
    }

    private static int myCompare(int x, int y, int K){
        if (Math.abs(K - x) > Math.abs(K - y)){
            return y;
        } else if (Math.abs(K - x) == Math.abs(K - y)){
            return Math.min(x, y);
        }
        return x;
    }

    private static int find(int[] mix1, int[] mix2, int K) {
        int res = Integer.MAX_VALUE;

        for (int n1 : mix1) {
            int idx = binarySearch(mix2, K - n1), minSum = Integer.MAX_VALUE;

            if (idx == 0){
                minSum = n1 + mix2[idx];
            }
            else if (idx == mix2.length){
                minSum = n1 + mix2[idx - 1];
            }
            else if (n1 + mix2[idx] == K){
                return K;
            }
            else {
                minSum = myCompare(n1 + mix2[idx - 1], n1 + mix2[idx], K);
            }

            res = myCompare(res, minSum, K);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[4][N];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] mix1 = mix(arr[0], arr[1]);
            int[] mix2 = mix(arr[2], arr[3]);
            Arrays.sort(mix2);

            sb.append(find(mix1, mix2, K)).append('\n');

        }
        System.out.println(sb);

    }
}