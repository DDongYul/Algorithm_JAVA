import java.io.*;
import java.util.*;
/**
 * 유니온 파인드
 * 각 섬을 잇는 다리의 최소 거리의 합(2이상)
 * 다리는 N-1개 
 * 크루스칼...? 
 */

public class Main {
		
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge{
		int s;
		int e;
		int dist;
		
		public Edge(int s, int e, int dist) {
			this.s = s;
			this.e = e;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return ("s " + s + " e " + e + " dist " + dist);
		}
		
	}
	
	static class Island{
		int index; //섬의 번호
		List<Pos> list;
		
		public Island(int index) {
			this.index = index;
			list = new ArrayList<Pos>();
		}
	}
	
	//
	private static void findIsland() {
		boolean[][] visited = new boolean[N][M];
		int idx = 1;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(!visited[i][j] && board[i][j]==1) {
					Island island = new Island(idx);
					island.list.add(new Pos(i,j));
					board[i][j] = idx;
					Deque<Pos> deque = new ArrayDeque<Pos>();
					deque.add(new Pos(i,j));
					//BFS
					while(!deque.isEmpty()) {
						Pos curr = deque.poll();
						int x = curr.x;
						int y = curr.y;
						for(int k = 0; k<4; k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && board[nx][ny]==1) {
								Pos pos = new Pos(nx,ny);
								visited[nx][ny] = true;
								board[nx][ny] = idx;
								island.list.add(pos);
								deque.add(pos);
							}
						}
					}
					islands.add(island);
					idx++;
				}
			}
		}
	}
	
	private static void makeEdge() {
		for (Island island : islands) {
			int index = island.index;
			for (Pos pos : island.list) {
				int x = pos.x;
				int y = pos.y;
				for(int i = 0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					int dist = 0;
					while(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny] == 0) {
						dist += 1;
						nx += dx[i];
						ny += dy[i];
					}
					if(nx>=0 && nx<N && ny>=0 && ny<M && dist>=2) {
						edges.add(new Edge(index,board[nx][ny],dist));
					}
				}
			}
		}
	}
	
	private static int find(int x) {
		 while (!(parent[x] == x)) {
	            x = parent[x];
	        }
	        return x;
	}
	
	private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
	
	static int N,M,iCnt;
	static int[][] board;
	static List<Edge> edges;
	static List<Island> islands;
	static int[] parent;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		edges = new ArrayList<Edge>();
		islands = new ArrayList<Island>();
		//parent해주기
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findIsland();
		parent = new int[islands.size()+1];
		for(int i = 1; i<islands.size(); i++) {
			parent[i] = i;
		}
		
		makeEdge();
		Collections.sort(edges, (o1,o2) -> o1.dist - o2.dist);
//		for (Edge edge : edges) {
//			System.out.println(edge.toString());
//		}
		
		int sum = 0;
		for (Edge edge : edges) {
            if (!(find(edge.s) == find(edge.e))) {  //싸이클 여부
                sum += edge.dist;
                union(edge.s, edge.e);
            }
        }
		boolean flag = true;
		int temp = parent[1];
		for(int i = 1; i<parent.length; i++) {
			if(temp != find(parent[i])) {
				flag = false;
			}
		}
		if(flag) {
			System.out.println(sum);
		}
		else {
			System.out.println(-1);
		}
		
	}
}