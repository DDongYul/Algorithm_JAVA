import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static String convertToBase(int num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int remainder = num % base;
            if (remainder < 10) {
                sb.append((char) ('0' + remainder));
            } else {
                sb.append((char) ('A' + remainder - 10)); // 10 이상의 경우 A, B, C로 표현
            }
            num /= base;
        }
        return sb.toString();
    }

    public static boolean isPalindromeInAnyBase(int num) {
        for (int base = 2; base <= 64; base++) {
            String converted = convertToBase(num, base);
            if (isPalindrome(converted)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(isPalindromeInAnyBase(num) ? 1 : 0).append("\n");
        }
        System.out.print(sb.toString());
    }
}