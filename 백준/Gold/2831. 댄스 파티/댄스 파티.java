import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> manSmall = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> manBig = new PriorityQueue<>();
        PriorityQueue<Integer> womanSmall = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> womanBig = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            int num = Integer.parseInt(st.nextToken());
            if(num<0){
                manSmall.add(num);
            }else{
                manBig.add(num);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            int num = Integer.parseInt(st.nextToken());
            if(num<0){
                womanSmall.add(num);
            }else{
                womanBig.add(num);
            }
        }

        int answer = 0;
        int man = 0;
        int woman = 0;

        if(!manSmall.isEmpty()) {
            man = manSmall.peek();
        }
        if(!womanBig.isEmpty()) {
            woman = womanBig.peek();
        }
        while (!manSmall.isEmpty() && !womanBig.isEmpty()){
            if(Math.abs(man)>woman){
                answer+=1;
                if(!manSmall.isEmpty()) {
                    manSmall.poll();
                }
                if(!womanBig.isEmpty()) {
                    womanBig.poll();
                }
            }
            else if(Math.abs(man)<=woman){
                if(!manSmall.isEmpty()) {
                    manSmall.poll();
                }
            }
            if(manSmall.isEmpty() || womanBig.isEmpty()){
                break;
            }
            man = manSmall.peek();
            woman = womanBig.peek();
        }

        if(!manBig.isEmpty()) {
            man = manBig.peek();
        }
        if(!womanSmall.isEmpty()) {
            woman = womanSmall.peek();
        }
        while (!womanSmall.isEmpty() && !manBig.isEmpty()){
            if(Math.abs(woman)>man){
                answer+=1;
                if(!womanSmall.isEmpty()) {
                    womanSmall.poll();
                }
                if(!manBig.isEmpty()) {
                    manBig.poll();
                }
            }
            else if(Math.abs(woman)<=man){
                if(!womanSmall.isEmpty()) {
                    womanSmall.poll();
                }
            }
            if(womanSmall.isEmpty() || manBig.isEmpty()){
                break;
            }
            woman = womanSmall.peek();
            man = manBig.peek();
        }
        System.out.println(answer);
    }

}