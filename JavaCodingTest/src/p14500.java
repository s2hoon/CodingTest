import java.util.*;
import java.io.*;


public class p14500 {

    static int N;
    static int M;
    static int [][] graph;
    static int answer =0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    public static void recursive(int x, int y , int cnt, int sum){

        if(cnt == 0){
            answer = Math.max(sum, answer);
            return;
        }
        
        visited[x][y] =true;
        for(int i = 0 ; i< 4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= N || nx <0 || ny >= M || ny<0 || visited[nx][ny] != false){
                continue;
            }
      
            recursive(nx,ny, cnt-1, sum+graph[nx][ny]);
          
        }
        visited[x][y] = false;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i =0 ; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j< M ; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        for(int i =0; i< N;i++){
            for(int j=0; j<M; j++){
                recursive(i,j, 3, graph[i][j]);
            }
        }

        for(int i =0 ; i< N ; i++){
            for(int j =0; j< M ; j++){

                if( j-1 >= 0 &&  i +1 < N && i-1 >= 0 ){
                    answer = Math.max(answer, graph[i][j] + graph[i][j-1] + graph[i+1][j] + graph[i-1][j]);
                }
                if( j+1 < M &&  i +1 < N && i-1 >= 0 ){
                    answer = Math.max(answer,graph[i][j] + graph[i][j+1] + graph[i+1][j] + graph[i-1][j]);
                }
                if( i-1 >= 0 && j+1 < M && j-1 >= 0){
                    answer = Math.max(answer, graph[i][j] + graph[i][j+1] + graph[i][j-1] + graph[i-1][j]);
                }
                if( i+1 < N && j+1 < M && j-1 >= 0)
                    answer = Math.max(answer, graph[i][j] + graph[i][j+1] + graph[i][j-1] + graph[i+1][j]);
                }
        
               
            }

        System.out.println(answer);

    }

}



