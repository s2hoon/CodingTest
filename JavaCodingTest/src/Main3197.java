import java.io.*;
import java.util.*;
public class Main3197 {

	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static int R;
	static int C;
	static char [][] graph;
	static boolean [][] visited;
	static Queue<Point> queue;
	static List<Point> swan;
	static class Point{
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x =x;
			this.y =y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}
	public static int check() {
		Queue<Point> nextQueue =new LinkedList<>();

		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i =0;i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx >= R || nx <0 || ny >= C || ny <0) {
					continue;
				}
				if(visited[nx][ny] ==false) {
					if(graph[nx][ny]=='L') {
						return 1;
					}
					if(graph[nx][ny]=='.') {
						queue.add(new Point(nx,ny));
						visited[nx][ny] = true;
					}else if(graph[nx][ny]=='X'){
						nextQueue.add(new Point(nx,ny));
                        visited[nx][ny] = true;
					}
				}
			}
		
		}

		queue = nextQueue;
		return 0;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new char[R][C];
		queue = new LinkedList<>();
		swan = new ArrayList<>();
		visited = new boolean[R][C];
		Queue<Point> meltQueue = new LinkedList<>();
		for(int i =0;i < R; i++) {
			String  t = br.readLine();
			for(int j =0 ;j< C; j++) {
				graph[i][j] = t.charAt(j);
		
				if(graph[i][j]=='L' && swan.isEmpty()) {
					swan.add(new Point(i,j));
				}
				if(graph[i][j]=='.' || graph[i][j]=='L') {
					meltQueue.add(new Point(i,j));
				}
			}
		}
	
		queue.add(new Point(swan.get(0).x, swan.get(0).y));
		visited[queue.peek().x][queue.peek().y] = true;
		
		
		int time = 0;
		while(true) {
			// L 과 L 이 만날수 있다면 종료
			if(check()==1) {
				break;
			}
			// 아니라면 얼음 녹이기
			// 물이라면 4방향 탐색해서 녹이기
            int size = meltQueue.size();
            for(int t =0;t < size; t++) {
                Point p =meltQueue.poll();
                for(int d =0;d< 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if(nx >= R || nx <0 || ny >=C || ny <0) {
                        continue;		
                    }
                    // 주변에 얼음이 있다면 녹여야함
                    if(graph[nx][ny]=='X') {
                        graph[nx][ny] = '.';
                        meltQueue.add(new Point(nx,ny));
                        
                    }
                }
            }

			time +=1;
			
		}
		System.out.println(time);

	}


}