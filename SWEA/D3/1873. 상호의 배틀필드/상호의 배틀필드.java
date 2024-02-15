import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            sb.append("#").append(t + 1).append(" ");
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] arr = new char[H][W];

            //전차 좌표
            int cx = 0;
            int cy = 0;

            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    char curr = str.charAt(j);
                    if (curr == '^' || curr == 'v' || curr == '<' || curr == '>') {
                        cx = i;
                        cy = j;
                    }
                    arr[i][j] = curr;
                }
            }

            int num = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i = 0; i < num; i++) {
                char op = str.charAt(i);

                switch (op) {
                    case 'U':
                        arr[cx][cy] = '^';
                        if (cx - 1 >= 0 && arr[cx - 1][cy] == '.') {
                            arr[cx][cy] = '.';
                            cx -= 1;
                            arr[cx][cy] = '^';
                        }
                        break;
                    case 'D':
                        arr[cx][cy] = 'v';
                        if (cx + 1 < H && arr[cx + 1][cy] == '.') {
                            arr[cx][cy] = '.';
                            cx += 1;
                            arr[cx][cy] = 'v';
                        }
                        break;
                    case 'L':
                        arr[cx][cy] = '<';
                        if (cy - 1 >= 0 && arr[cx][cy - 1] == '.') {
                            arr[cx][cy] = '.';
                            cy -= 1;
                            arr[cx][cy] = '<';
                        }
                        break;
                    case 'R':
                        arr[cx][cy] = '>';
                        if (cy + 1 < W && arr[cx][cy + 1] == '.') {
                            arr[cx][cy] = '.';
                            cy += 1;
                            arr[cx][cy] = '>';
                        }
                        break;

                    case 'S':
                        switch (arr[cx][cy]) {
                            case '<':
                                for (int k = cy; k >= 0; k--) {
                                    if (arr[cx][k] == '*') {
                                        arr[cx][k] = '.';
                                        break;
                                    } else if (arr[cx][k] == '#') {
                                        break;
                                    }
                                }
                                break;
                            case '>':
                                for (int k = cy; k < W; k++) {
                                    if (arr[cx][k] == '*') {
                                        arr[cx][k] = '.';
                                        break;
                                    } else if (arr[cx][k] == '#') {
                                        break;
                                    }
                                }
                                break;
                            case '^':
                                for (int k = cx; k >= 0; k--) {
                                    if (arr[k][cy] == '*') {
                                        arr[k][cy] = '.';
                                        break;
                                    } else if (arr[k][cy] == '#') {
                                        break;
                                    }
                                }
                                break;
                            case 'v':
                                for (int k = cx; k < H; k++) {
                                    if (arr[k][cy] == '*') {
                                        arr[k][cy] = '.';
                                        break;
                                    } else if (arr[k][cy] == '#') {
                                        break;
                                    }
                                }
                                break;
                        }
                        break;
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }

        }

        System.out.println(sb);
    }
}