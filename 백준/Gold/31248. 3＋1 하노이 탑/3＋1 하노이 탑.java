import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n-2개를 1에 옮기고 1개를 2에 옮기고 moveD 두번 
 *
 */
public class Main {

	static StringBuilder sb;
	static int cnt = 0;
	static void move(int n, int start, int destination) {
		if (n == 1) {
			cnt+=1;
			char s = (char) (start+65);
			char d = (char) (destination+65);
			sb.append(s).append(" ").append(d).append("\n");
			return;
		}
		if (start == 0) {
			if(destination == 1) {
				move(n - 1, 0, 2);
				move(1,0,1);
				move(n-1,2,1);
			}
			else if(destination == 2) {
				move(n - 1, 0, 1);
				move(1,0,2);
				move(n-1,1,2);
			}
		}
		else if(start == 1){
			if(destination==0) {
				move(n - 1, 1, 2);
				move(1,1,0);
				move(n-1,2,0);
			}
			else if(destination==2) {
				move(n - 1, 1, 0);
				move(1,1,2);
				move(n-1,0,2);
			}
		}
		else if(start == 2){
			if(destination == 1) {
				move(n-1,2,0);
				move(1,2,1);
				move(n-1,0,1);
			}
			else if(destination == 0){
				move(n - 1, 2, 1);
				move(1,2,0);
				move(n-1,1,0);	
			}
		}
	}
	
	static void moveD(int start) {
		cnt+=1;
		char s = (char) (start+65);
		sb.append(s).append(" ").append('D').append("\n");
	}

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(1);
			System.out.println(sb.append('A').append(" ").append('D'));
			return;
		}
		
		boolean flag = true;
		for(int n = N; n>=2; n-=2) {
			if(n==2) {
				if(flag) {
					move(1,0,1);
					moveD(0);
					moveD(1);
				}
				else {
					move(1,1,0);
					moveD(1);
					moveD(0);
				}
				break;
			}
			if(flag) {
				move(n-2,0,1);
				move(1,0,2);
				moveD(0);
				moveD(2);
				if(n==3) {
					moveD(1);
				}
				flag=false;
			}
			else {
				move(n-2,1,0);
				move(1,1,2);
				moveD(1);
				moveD(2);
				if(n==3) {
					moveD(0);
				}
				flag=true;
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}