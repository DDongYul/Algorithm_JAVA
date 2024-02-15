import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *	그리디 적용 -> 왼쪽 위부터 탐색시작하고 오른쪽 위로 갈 수 있으면 무조건 위로 간다.
 *	실패하면 경로 버려야한다. -> 그럴 필요가 없다. 어차피 위에서 못가는 경로면 아래 출발도 못가는 경로
 *	따라서 도착 못하더라도 방문처리 해버려도 된다.
 *	만약 우선순위 방향으로 탐색을 성공했으면 나머지 방향은 탐색 x -> flag 사용 
 */
public class Main {
	
	static int R,C;
	static int cnt = 0; 
	static char[][] arr;
	static boolean[][] visited;
	
	static boolean DFS(int x, int y) {
		boolean flag = false;
		if(y == C-1) {
			cnt+=1;
			return true;
		}
		
		arr[x][y] = 'x';
		
		if(x-1>=0 && arr[x-1][y+1] == '.') {
			flag = DFS(x-1,y+1);
		}
		if(!flag && arr[x][y+1] == '.'){
			flag = DFS(x,y+1);
		}
		if(!flag && x+1<R && arr[x+1][y+1] == '.'){
			flag = DFS(x+1,y+1);
		}
		return flag;
	}
	
	public static void main	(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i<R; i++) {
			String str = br.readLine();
			for(int j = 0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i<R; i++) {
			DFS(i,0);
		}

		System.out.println(cnt);

	}
}