import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /**
     * 투포인터 사용해서 visited 체크해가며 진행 -> visited를 int형으로 해서 2개 중복 들어간 것도 체크
     * 종류를 의미하는 cnt 변수를 사용해서 만약 이번 라운드에 개수가 1-> 0이 되면 cnt 감소, 2->1과 같이 0이 아니면 감소시키지 않음
     * 위와 같은 방식으로 진행
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //총 접시 수
        int d = Integer.parseInt(st.nextToken()); //메뉴에 있는 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 개수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호

        int[] visited = new int[d+1];
        int[] arr = new int[N+k]; // 뒤에서부터 시작하는 경우를 위해 k만큼 더해줌

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N; i < N+k; i++) {
            arr[i] = arr[i-N];
        }

        int p1 = 0;
        int p2 = k-1;
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            if(visited[arr[i]] == 0){
                cnt+=1;
            }
            visited[arr[i]]+=1;
        }

        int answer = 0;
        if(visited[c]>0){
            answer = cnt;
        }
        else{
            answer = cnt+1;
        }

        while (p2<N+k-1){
            if(visited[arr[p1]] == 1){
                cnt-=1;
            }
            visited[arr[p1]]-=1;
            p1+=1;

            p2+=1;
            if(visited[arr[p2]] == 0){
                cnt+=1;
            }
            visited[arr[p2]]+=1;

            if(visited[c]>0){
                answer = Math.max(answer, cnt);
            }
            else{
                answer = Math.max(answer,cnt+1);
            }
        }
        System.out.println(answer);
    }

}