import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            while (!stack.isEmpty() && K>0 && stack.peek()<c){
                stack.pop();
                K--;
            }
            stack.push(c);
        }
        while (K>0){
            stack.pop();
            K--;
        }
        for(char c : stack){
            sb.append(c);
        }
        System.out.println(sb);
    }
}