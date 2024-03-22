
import java.io.*;
import java.util.*;
public class Main1245 {

	static int N ;
	static int M;
	static int [][]graph;                            
	static boolean [][] visited;
	static int [] dx = {0,1,1,1,0,-1,-1,-1};
	static int [] dy = {1,1,0,-1,-1,-1,0,1};
	static List<int[]> bong;
	public static void DFS(int x, int y) {
		visited[x][y] = true;
		bong.add(new int[] {x,y});
		for(int i =0;i< 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= N || nx <0 || ny >= M || ny <0) {
				continue;
			}
			if(visited[nx][ny] == false && graph[nx][ny] == graph[x][y]) {
				DFS(nx,ny);
			}
		}

	}
	private static boolean check(int x, int y) {
  
		for(int i =0;i <8;i++ ) {
			int nx = x+dx[i];
			int ny = y+dy[i];
            if(nx >= N || nx <0 || ny >= M || ny <0){
                continue;
            }
			if(graph[nx][ny]>graph[x][y]){
                return false;
            }

		}
        return true;
		
	}

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		visited = new boolean[N][M];
		for(int i =0 ;i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt =0;
        for(int i =0;i<N; i++){
            for(int j =0;j<M; j++){
                if(visited[i][j] ==false){
                    bong = new ArrayList<>();
                    DFS(i,j);
                    // for(int t=0;t<bong.size();t++){
                    //     System.out.print(bong.get(t)[0]+" " +bong.get(t)[1]+".");
                    // }
                    // System.out.println();
                    boolean f = true;
                    for(int t =0;t<bong.size();t++){
                        if(!check(bong.get(t)[0],bong.get(t)[1])){
                            f = false;
                            break;
                        }
                    }
                    if(f==true){
                       
                        cnt+=1;
                    }

                }
              
            }
        }

        System.out.println(cnt);
	
		
	}


}
