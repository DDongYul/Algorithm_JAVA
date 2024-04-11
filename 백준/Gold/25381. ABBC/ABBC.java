import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
    //앞에 2부터 뒤에 3 모두 없애주기
    //나머지 1 처리?
    //BAABBC
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        int n = str.length();
        LinkedList<Integer> one = new LinkedList<>();
        LinkedList<Integer> two = new LinkedList<>();
        LinkedList<Integer> three = new LinkedList<>();
        for(int i = 0; i<n; i++) {
            if (str.charAt(i) == 'A') {
                one.add(i);
            } else if (str.charAt(i) == 'B') {
                two.add(i);
            } else {
                three.add(i);
            }
        }
        // 2,3 제거
        // 3의 index가 2보다 커야함
        int answer = 0;
//        LinkedList<Integer> twotwo = new LinkedList<>();
        while (!two.isEmpty() && !three.isEmpty()) {
            int idx2 = two.peekFirst();
            int idx3 = three.peekFirst();
            if(idx3>idx2){
                two.removeFirst();
                three.removeFirst();
                answer+=1;
            }
            else if(idx3<idx2){
                three.removeFirst();
            }
        }

        //2에 남은게 있으면 twotwo로 옮겨주기
//        while (!two.isEmpty()){
//            twotwo.add(two.removeFirst());
//        }

        while (!two.isEmpty() && !one.isEmpty()) {
            int idx1 = one.peekFirst();
            int idx2 = two.peekFirst();
            if(idx2>idx1){
                one.removeFirst();
                two.removeFirst();
                answer+=1;
            }
            else if(idx2<idx1){
                two.removeFirst();
            }
        }
        System.out.println(answer);
    }
}