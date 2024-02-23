import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    /**
     * 큐에 주자를 넣어가며 진행 큐에서 뺀 주자에 이번 타석의 결과를 더해주고, 만약 4가 넘으면 점수에 1을 더해주고 넘지 않으면 다시 큐에 넣어주기
     * <p>
     * 조합으로 순서를 만들어줌 -> 모든 이닝에 적용 야구 점수를 계산하는 simulation 함수 만들기
     */
    static int N;
    static int[][] input;
    static int[] order; //index번 차례에 value번 타자 공격 order[3] = 0
    static int answer = 0;

    static int simulation(int[] order) {
        int curr = 0; //현재 타자
        int score = 0; //총점
        for (int i = 0; i < N; i++) {
            int out = 0;
            int cnt = 0; //이번 이닝에서 낸 점수
            Deque<Integer> deque = new ArrayDeque<>(); //주자 표현
            while (out < 3) {
//                System.out.println("order = " + order[curr]);
//                System.out.println("result = " + input[i][order[curr]]);
                int result = input[i][order[curr]];
                if (result == 0) {
                    out += 1;
                    curr = (curr + 1) % 9;
                    continue;
                }
                if(result == 4){
                    cnt += deque.size();
                    cnt+=1;
                    deque.clear();
                    curr = (curr + 1) % 9;
                    continue;
                }
                int temp = deque.size();
                for (int j = 0; j < temp; j++) {
                    int c = deque.removeFirst();
                    c += result;
                    if (c >= 4) {
                        cnt += 1;
                    } else {
                        deque.add(c);
                    }
                }
                deque.add(result);
                curr = (curr + 1) % 9;
            }
            score += cnt;
        }
        return score;
    }

    static boolean[] visitied;

    //순서 만들어주기
    static void sol(int depth) {
        if (depth == 9) {
//            System.out.println(Arrays.toString(order));
            answer = Math.max(answer, simulation(order));
        }
        for (int i = 0; i < 9; i++) {
            if (!visitied[i]) {
                order[i] = depth;
                visitied[i] = true;
                sol(depth + 1);
                visitied[i] = false;
                order[i] = -1;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new int[N][9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visitied = new boolean[9];
        order = new int[9];
        order[3] = 0;
        visitied[3] = true;
        sol(1);
        System.out.println(answer);
    }
}