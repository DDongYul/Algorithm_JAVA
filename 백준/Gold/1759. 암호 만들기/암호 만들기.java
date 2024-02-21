import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L,C;
    static char[] arr;
    static char[] answer;
    static StringBuilder sb = new StringBuilder();
    static char[] vowel = {'a','e','i','o','u'};

    static boolean isVowel(char c) {
        if(c == 'a' || c == 'e'|| c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }

    static void sol(int depth, int curr, int c, int v) {
        if (depth == L) {
            if(c>=2 && v>=1) {
                sb.append(String.copyValueOf(answer)).append("\n");
            }
            return;
        }

        for (int i = curr; i < C; i++) {
            answer[depth] = arr[i];
            if(isVowel(answer[depth])){
                sol(depth+1,i+1,c,v+1);
            }else{
                sol(depth+1,i+1,c+1,v);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        answer = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        sol(0,0,0,0);
        System.out.println(sb);
    }

}