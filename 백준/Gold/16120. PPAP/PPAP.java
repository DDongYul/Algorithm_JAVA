import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean flag = false; //이전이 A인지 여부
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(flag && c == 'P'){
                stack.pop();
                for(int j = 0; j < 2; j++){
                    if(stack.isEmpty() || stack.peek() != 'P'){
                        System.out.println("NP");
                        System.exit(0);
                    }else{
                        stack.pop();
                    }
                }
                stack.push(c);
                flag = false;
                continue;
            }
            if(c=='A'){
                flag = true;
                stack.push(c);
                continue;
            }
            stack.push(c);
        }
        if(stack.size()==1 && stack.peek()=='P'){
            System.out.println("PPAP");
        }else{
            System.out.println("NP");
        }
    }

}