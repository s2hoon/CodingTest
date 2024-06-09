import java.util.*;
import java.io.*;
public class Main16933 {
	

	static int N;
	static int M;
	static int K;
	static int[][] graph;
	static int[][][][] visited;
	static int[] dx = new int[] {0,1,0,-1};
	static int[] dy = new int[] {1,0,-1,0};
	static int result = Integer.MAX_VALUE;
	
	
	public static void BFS(int x , int y, int cnt, int n) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {return a[4]-b[4];});
		queue.add(new int[] {x,y,cnt,n,0});
		visited[x][y][cnt][n] = 1;
		
		while(!queue.isEmpty()) {
			int[] v=queue.poll();
			int tx = v[0];
			int ty = v[1];
			int tcnt = v[2];
			int tn = v[3];
            int tdist = v[4];
//			System.out.println(tx+" "+ ty  +" " +tcnt+ " "+ tn);
			if(tx == N-1 && ty == M-1) {
				result = Math.min(result, tdist);
                continue;
			}
		
			for(int i =0; i< 4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				if(nx >= N || nx< 0 || ny>= M || ny<0) {
					continue;
				}
				
				if(graph[nx][ny]==0) {
					if(visited[nx][ny][tcnt][(tn+1)%2] > tdist + 1) {
						visited[nx][ny][tcnt][(tn+1)%2] = tdist +1;
						queue.offer(new int[] {nx,ny,tcnt, (tn+1)%2, tdist +1});
					}	
					else if(visited[tx][ty][tcnt][(tn+1)%2] > tdist +1) {
						visited[tx][ty][tcnt][(tn+1)%2] = tdist +1;
						queue.offer(new int[] {tx,ty,tcnt, (tn+1)%2, tdist +1});
					}
					
					
				}else {
					if(tn ==0 && tcnt < K && visited[nx][ny][tcnt+1][(tn+1)%2]> tdist +1) {
						visited[nx][ny][tcnt+1][(tn+1)%2] =tdist +1;
						queue.offer(new int[] {nx,ny,tcnt+1, (tn+1)%2,tdist +1});
					}else if( tn==1&& tcnt < K && visited[nx][ny][tcnt+1][tn]>tdist +2) {
						visited[nx][ny][tcnt+1][tn] =tdist +2;
						queue.offer(new int[] {nx,ny,tcnt+1, tn,tdist +2});
					}
					
				}
				
			

		}
		}
	}

		
	
	
	
	
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		visited = new int[N][M][K+1][2];

		for(int i =0; i< N ; i++) {
			String temp =br.readLine();
			for(int j = 0; j<M ; j++) {
				graph[i][j] = temp.charAt(j)-'0';
                for(int k =0 ;k<K+1;k++){
                    Arrays.fill(visited[i][j][k],Integer.MAX_VALUE);
                }
			}
			
		}
		BFS(0,0,0,0);
		
		
		if(result ==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result+1);
		}
		
	}
}