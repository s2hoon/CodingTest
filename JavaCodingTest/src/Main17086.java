import java.util.*;
import java.io.*;
public class Main17086 {
    static int result;
    static int N;
    static int M;
    static int [][] graph;
    static boolean [][] visited;
    static int [] dx = {0,1,1,1,0,-1,-1,-1};
    static int [] dy = {1,1,0,-1,-1,-1,0,1};
    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int [] t =queue.poll();

            for(int i =0;i< 8; i++){
                int nx = dx[i] + t[0];
                int ny = dy[i] + t[1];
                if(nx >= N || nx <0 || ny>= M || ny <0){
                    continue;
                }
                if(visited[nx][ny] ==true){
                    continue;
                }
                if(graph[nx][ny]==1){
                    result = Math.max(result, t[2] + 1);
                    return;
                }
                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny,t[2]+1 });
                
            }

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        result = 0;
        for(int i =0 ;i< N; i++){
            st=  new StringTokenizer(br.readLine());
            for(int j =0 ;j <M ;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i =0 ;i< N; i++){
            for(int j =0 ;j< M; j++){
                if(graph[i][j] == 0) {
                    visited = new boolean[N][M];
                    BFS(i,j);
                }
            }
        }
        System.out.println(result);




    }
}
