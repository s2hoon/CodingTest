
import java.io.*;
import java.util.*;
public class Main15683 {
	
	static int N;
	static int M;
	static int [][] graph;
	static int [][] temp_graph;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static int [] dcctv = {0,4,2,4,4,1};
	static List<int[]> cctvs;
	static int tot = 0;
	static int result = 0;

	
	public static int set(int x, int y, int d, int s,Stack<int[]> temp_stack) {
		int cnt = 0;
		
		while(true) {
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 격자를 넘어감다면
			if(nx >= N || nx < 0 || ny >= M || ny<0) {
				return cnt;
			}
			// 벽이라면
			if(graph[nx][ny] == 6){
				return cnt;
			}
			if(graph[nx][ny] == 0) {
				temp_stack.add(new int[]{nx,ny});
				cnt +=1;
				graph[nx][ny] = s;
			}
			x= nx;
			y= ny;
		}	
	}
	
	public static void recursive(int r, int cnt) {

		if( r== cctvs.size()) {
			result = Math.max(result, cnt);
			for(int i =0; i< N; i++){
				System.out.println(Arrays.toString(graph[i]));
			}
			System.out.println(result);
			return;
		}
		int x = cctvs.get(r)[0];
		int y = cctvs.get(r)[1];
	
		if( graph[x][y] == 1) {		
		
			Stack<int[]> temp_stack = new Stack<>();
			int t = set(x,y,0,-1,temp_stack);
			recursive(r+1, cnt+t);
			back(temp_stack);

			temp_stack = new Stack<>();
			t = set(x,y,1,-1,temp_stack);
			recursive(r+1, cnt+t);
			back(temp_stack);
	
			temp_stack = new Stack<>();
			t = set(x,y,2,-1,temp_stack);
			recursive(r+1, cnt+t);
			back(temp_stack);
	
			temp_stack = new Stack<>();
			t = set(x,y,3,-1,temp_stack);
			recursive(r+1, cnt+t);
			back(temp_stack);
		}
		// if(graph[x][y] == 2) {
		
		// 	int t = set(x,y,0,-1);
		// 	int t2 = set(x,y,2,-1);
		// 	recursive(r+1, cnt+t+t2);
		// 	back();
		// 	t = set(x,y,1,-1);
		// 	t2 = set(x,y,3,-1);
		// 	recursive(r+1, cnt+t+t2);
		// 	back();
		// }
		// if(graph[x][y] == 3) {
	
		// 	int t = set(x,y,0,-1);
		// 	int t2 = set(x,y,1,-1);
		// 	recursive(r+1, cnt+t+t2);
		// 	back();

		// 	t = set(x,y,1,-1);
		// 	t2 = set(x,y,2,-1);
		// 	recursive(r+1, cnt+t+t2);
		// 	back();

		// 	t = set(x,y,2,-1);
		// 	t2 = set(x,y,3,-1);
		// 	recursive(r+1, cnt+t+t2);
		// 	back();

	
		// 	t = set(x,y,3,-1);
		// 	t2 = set(x,y,0,-1);
		// 	recursive(r+1, cnt+t+t2);
		// 	back();

		// }
		
		// if(graph[x][y] == 4) {
	
		// 	int t = set(x,y,0,-1);
		// 	int t2 = set(x,y,1,-1);
		// 	int t3 = set(x,y,2,-1);
		// 	recursive(r+1, cnt+t+t2+t3);
		// 	back();
		
		// 	t = set(x,y,1,-1);
		// 	t2 = set(x,y,2,-1);
		// 	t3 = set(x,y,3,-1);
		// 	recursive(r+1, cnt+t+t2+t3);
		// 	back();
		
		// 	t = set(x,y,2,-1);
		// 	t2 = set(x,y,3,-1);
		// 	t3 = set(x,y,0,-1);
		// 	recursive(r+1, cnt+t+t2+t3);
		// 	back();
		// 	t = set(x,y,3,-1);
		// 	t2 = set(x,y,0,-1);
		// 	t3 = set(x,y,1,-1);
		// 	recursive(r+1, cnt+t+t2+t3);
		// 	back();
			
		// }
		// if(graph[x][y] == 5) {
		
		// 	int t = set(x,y,3,-1);
		// 	int t2 = set(x,y,0,-1);
		// 	int t3 = set(x,y,1,-1);
		// 	int t4 = set(x,y,2,-1);
		// 	recursive(r+1, cnt+t+t2+t3+t4);
		// 	back();
		
		// }

	}


	
	private static void back(Stack<int[]> temp_stack){
		while(!temp_stack.isEmpty()){
			int [] t = temp_stack.pop();
			graph[t[0]][t[1]] = 0;
		}
	}

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tot = N*M;
		graph = new int[N][M];
		temp_graph = new int[N][M];
		cctvs = new ArrayList<>();
		int wall = 0;
		for(int i =0;i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				temp_graph[i][j] = graph[i][j];
				if(graph[i][j] >=1 && graph[i][j] <=5) {
					cctvs.add(new int[] {i,j});
				}
				if(graph[i][j]==6) {
					wall +=1;
				}
			}
		}

		recursive(0,0);
		System.out.println(tot - result - cctvs.size()-wall);

		
	}


}
