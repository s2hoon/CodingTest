import java.util.*;
import java.io.*;
public class p16929 {


    static int N;
    static int M;
    static String[][]  graph;
    static int[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean answer = false;

    public static void DFS(int x,int y, int startx, int starty){
    
        
        for(int i = 0; i<4;i++){
            int nx = x +dx[i];
            int ny = y +dy[i];

            if(nx == startx && ny == starty && visited[x][y]>=3){
                answer = true;
            }


            if(nx >=N || nx < 0 || ny >=M || ny<0){
                continue;
            }

            if (visited[nx][ny]==-1 && graph[nx][ny].equals(graph[x][y])){
                    visited[nx][ny] = visited[x][y] +1;
                    DFS(nx,ny,startx,starty);
            }


        }


    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new String[N][M];
        visited =new int[N][M];


        for(int i=0 ;i < N; i++){
            String[] line = br.readLine().split("");
            for(int j=0;j < M; j++){
                graph[i][j] = line[j];
                visited[i][j] = -1;
            }
        }

        for (int i = 0; i< N ;i++){
            for( int j=0; j<M ;j++){
                for(int k =0;k< N ;k++){
                    for(int t=0; t<M;t++){
                        visited[k][t] = -1;
                    }
                }
                visited[i][j] = 0;
                DFS(i,j,i,j);
            }

        }

        if (answer == true){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }


    }

}
