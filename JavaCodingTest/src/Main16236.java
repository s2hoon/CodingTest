
import java.util.*;
import java.io.*;
public class Main16236 {

    static int N ;
    static int[][] graph;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int result;
    public static void BFS(int x, int y, int distance, int size, int cnt) {
        boolean [][] visited = new boolean[N][N];
        visited[x][y] = true;
        graph[x][y] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> { 
                if(o1[2] != o2[2]) {
                    return o1[2] - o2[2]; 
                } else if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            });
        pq.add(new int[] {x,y,distance});
        while(pq.size()!=0) {
            int[] v = pq.poll();
            int tx = v[0];
            int ty = v[1];
            int tdistance =v[2];
            if(graph[tx][ty] !=0 && graph[tx][ty] < size ) {
                graph[tx][ty] = 0;
                cnt +=1;
                result += tdistance;
                if(cnt == size) {
                    BFS(tx,ty,0,size+1,0);
                }
                else {
                    BFS(tx,ty,0,size,cnt);
                }
                continue;
            }
            
            
            for(int i =0; i< 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(nx >= N || nx<0 || ny>=N || ny<0 || graph[nx][ny] >size) {
                    continue;
                }
                if(visited[nx][ny] == false ){
                    visited[nx][ny] = true;
                    pq.add(new int[] {nx,ny,tdistance+1});
                    
                }
            
            }

        }
        

    }
    
    
    
    public static void main(String[] args)throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        int startx= 0;
        int starty= 0;
    
        for(int i =0; i< N ; i++) {
            st= new StringTokenizer(br.readLine());
            for(int j =0 ; j< N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 9) {
                    startx = i;
                    starty = j;
                }
                
            }
        }
        BFS(startx,starty,0,2,0);
        System.out.println(result);
        
        
        
    }
}