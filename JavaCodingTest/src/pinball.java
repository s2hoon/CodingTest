
import java.util.*;
import java.io.*;
public class pinball {
	static int T;
	static int N;
	static int [][] graph;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
    static int startX;
    static int startY;
    static boolean flag ;
	static HashMap<Integer, int[]> holes1 ;
	static HashMap<Integer, int[]> holes2 ;
	static List<Point> balls;

	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static int recursive(int x, int y ,int d, int cnt) {
       
      
        // 블랙홀 도착 이면 종료
        if(x!=N && x!=-1 && y!=N &&y!=-1){
            if(graph[x][y] == -1 ){
                return cnt;
            }
        }
        if( x == startX && y == startY && flag==true){
            return cnt;
        }
        flag = true;
        int nx = x +dx[d];
        int ny = y +dy[d];
        
        // 벽 부딪히면 방향 전환해서 gogo
        if(nx >= N || nx<0 || ny >= N || ny <0){
            return recursive(nx, ny, (d+2)%4, cnt+1);
        }
      
        // d 0 : 오른쪽 , 1 : 밑, 2: 왼쪽, 3: 위쪽
        if(graph[nx][ny] == 1){
            // 왼방향으로왔다면 , 위쪽으로
            if( d==2){
                return recursive(nx, ny, 3, cnt+1);
            }
            // 밑방향으로 왔다면, 오른쪽으로
            else if(d==1){
                return recursive(nx, ny, 0, cnt+1);
            }
            // 나머지는 반대로
            else{
                return recursive(nx, ny, (d+2)%4, cnt+1);
            }
        }
        else if(graph[nx][ny] == 2){
            // 왼방향으로왔다면 , 밑쪽으로
            if( d==2){
                return recursive(nx, ny, 1, cnt+1);
            }
            // 위방향으로 왔다면, 오른쪽으로
            else if(d==3){
                return recursive(nx, ny, 0, cnt+1);
            }
            // 나머지는 반대로
            else{
                return recursive(nx, ny, (d+2)%4, cnt+1);
            }
        }
        else if(graph[nx][ny] == 3){
            // 오른방향으로왔다면 , 밑쪽으로
            if( d==0){
                return recursive(nx, ny, 1, cnt+1);
            }
            // 위방향으로 왔다면, 왼쪽으로
            else if(d==3){
                return recursive(nx, ny, 2, cnt+1);
            }
            // 나머지는 반대로
            else{
                return recursive(nx, ny, (d+2)%4, cnt+1);
            }
        }
        else if(graph[nx][ny] == 4){
            // 아래방향으로왔다면 , 왼쪽으로
            if( d==1){
                return recursive(nx, ny, 2, cnt+1);
            }
            // 오른방향으로 왔다면, 위쪽으로
            else if(d==0){
                return recursive(nx, ny, 3, cnt+1);
            }
            // 나머지는 반대로
            else{
                return recursive(nx, ny, (d+2)%4, cnt+1);
            }
            }
        else if(graph[nx][ny] == 5){
            return recursive(nx, ny, (d+2)%4, cnt+1);
        }
        //웜홀
        else if(graph[nx][ny] >= 6 && graph[nx][ny] <=10){
            if(holes1.get(graph[nx][ny])[0]==nx && holes1.get(graph[nx][ny])[1] ==ny){
                return recursive(holes2.get(graph[nx][ny])[0],holes2.get(graph[nx][ny])[1], d , cnt);
            }
            if(holes2.get(graph[nx][ny])[0]==nx && holes2.get(graph[nx][ny])[1] ==ny){
                return recursive(holes1.get(graph[nx][ny])[0],holes1.get(graph[nx][ny])[1], d , cnt);
            }
        }
        else if(graph[nx][ny] == 0){
            return recursive(nx,ny,d,cnt);
        }
        return cnt;
	}

	private static int game() {
        int k  = 0;
		for(int t =0; t< balls.size(); t++) {
			int x = balls.get(t).x;
			int y = balls.get(t).y;
            startX = x;
            startY = y;
			// 재귀 시작
            // 4방향으로 시작
            for(int i =0;i< 4; i++){
                flag =false;
                k = Math.max(k,recursive(x, y, i, 0));
            }
        }

        return k;
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for(int test_case =0 ; test_case <T;test_case++) {
			getInput(br);
			int result = 0;
			result = Math.max(result,game());
			System.out.println("#"+(test_case+1)+" " +result);
		}
		
	}



	private static void getInput(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		graph = new int[N][N];
		balls = new ArrayList<>();
		holes1 = new HashMap<>();
		holes2 = new HashMap<>();
		for(int i =0;i < N ;i++) {
            String [] t = br.readLine().trim().split(" ");
			for(int j = 0; j< N ;j++) {
				graph[i][j] = Integer.parseInt(t[j]); 
				if(graph[i][j] ==0) {
					balls.add(new Point(i,j));
				}
				if(graph[i][j] >= 6  && graph[i][j] <=10 && !holes1.containsKey(graph[i][j])) {
					holes1.put(graph[i][j], new int[] {i,j});
				}else if(graph[i][j] >= 6  && graph[i][j] <=10){
                    holes2.put(graph[i][j], new int[] {i,j});
                }
				
			}
		}
	}
	

}
