import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[5];
        int cnt = 0;
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='q'){
                arr[0]+=1;
                cnt+=1;
                answer = Math.max(answer,cnt);
            }else if(c=='u'){
                if(arr[0]<=0){
                    answer = -1;
                    break;
                }else{
                    arr[0]-=1;
                    arr[1]+=1;
                }
            }else if(c=='a'){
                if(arr[1]<=0){
                    answer = -1;
                    break;
                }else{
                    arr[1]-=1;
                    arr[2]+=1;
                }
            }else if(c=='c'){
                if(arr[2]<=0){
                    answer = -1;
                    break;
                }else{
                    arr[2]-=1;
                    arr[3]+=1;
                }
            }else if(c=='k'){
                if(arr[3]<=0){
                    answer = -1;
                    break;
                }else{
                    arr[3]-=1;
                    cnt-=1;
                }
            }
        }
        if((arr[0] + arr[1] + arr[2] + arr[3]) !=0){
            answer = -1;
        }
        System.out.println(answer);
    }

}