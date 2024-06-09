import java.util.*;
import java.io.*;
public class Main2600 {

	static int N;
	static int M;
	static int K;
	static int [][] graph;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static int [][] visited;
	static boolean flag = false;
	
	
	public static void BFSGO(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y] = 1;
		while(!queue.isEmpty()) {
			int[] t = queue.poll();
			if(t[0]==N-1 && t[1] == M-1) {
				flag = true;
				System.out.println("YES");
				System.out.println(visited[N-1][M-1]-1);
				return;
			}
			for(int i = 0;i < 4; i++) {
				int nx = t[0] + dx[i];
				int ny = t[1] + dy[i];
				if(nx >= N || nx < 0 || ny >= M || ny <0) {
					continue;
				}
				if(graph[nx][ny] == 0 && visited[nx][ny]==0) {
					queue.add(new int[] {nx,ny});
					visited[nx][ny] = visited[t[0]][t[1]]+1;
				}
			}
		}
		
	}
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int d;
		public Point(int x, int y, int d) {
			this.x =x;
			this.y =y;
			this.d =d;
		}
		@Override
		public int compareTo(Point o) {
			return this.d - o.d;
		}
		
	}
	
	
	public static void BFS(int x, int y, int d) {
		graph[x][y] = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y,0));
		
		while(!queue.isEmpty()) {
			Point t = queue.poll();
			if(t.d == d) {
				continue;
			}
            
			for(int i = 0;i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				if(nx >= N || nx < 0 || ny >= M || ny <0) {
					continue;
				}
                if((nx ==N-1 && ny==M-1) || (nx == 0 && ny==0)){
                    continue;
                }

				if(graph[nx][ny] == 0) {
					queue.add(new Point(nx,ny,t.d+1));
					graph[nx][ny] = 1;
				}

			}	
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		visited = new int[N][M];
		K = Integer.parseInt(br.readLine());
		for(int i=0 ;i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			BFS(x-1,y-1,d);
			
		}

		BFSGO(0,0);
		if(flag==false) {
			System.out.println("NO");
			return;
		}
//		if(visited[N-1][M-1]==0) {
//			System.out.println("NO");
//		}else {
//			System.out.println("YES");
//			System.out.println(visited[N-1][M-1]-1);
//		}
	
		
		
	}
}