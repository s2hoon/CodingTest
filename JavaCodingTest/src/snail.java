import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


public class snail {
    
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int [][] graph;
    static int N;

    public static void recursive(int x, int y, int d, int count){
        if(count == N*N+1){
            return;
        }
        // 방문
        
        graph[x][y] = count;
        // 가야 하는 곳   
        int nx = x + dx[d];
        int ny = y + dy[d];
        if( (d == 0 && ny == N) || (d == 0 && graph[nx][ny]!=0)){
            int tx = x + dx[(d+1)%4];
            int ty = y + dy[(d+1)%4];
            recursive(tx, ty, (d+1)%4, count+1);
         
        }
        else if( (d == 1 && nx == N) || (d == 1 && graph[nx][ny]!=0)){
            int tx = x + dx[(d+1)%4];
            int ty = y + dy[(d+1)%4];
            recursive(tx, ty, (d+1)%4, count+1);
        
        }
        else if( (d == 2 && ny == -1) || (d == 2 && graph[nx][ny]!=0)){
            int tx = x + dx[(d+1)%4];
            int ty = y + dy[(d+1)%4];
            recursive(tx, ty, (d+1)%4, count+1);
          
        }
        else if( (d == 3 && nx == -1) || (d == 3 && graph[nx][ny]!=0)){
            int tx = x + dx[(d+1)%4];
            int ty = y + dy[(d+1)%4];
            recursive(tx, ty, (d+1)%4, count+1);
            
        }else if(graph[nx][ny]==0){
            recursive(nx,ny,d, count+1);
           
        }
    }

    public static void main(String[] args) throws Exception{
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i =0;i < T ;i++){
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            int count =1;
            int d =0;
            int x =0;
            int y =0;
            recursive(x, y, d, count);
            System.out.println("#"+(i+1));
            for(int t =0;t < N ;t++){
                for(int j =0; j< N ;j++){
                    System.out.print(graph[t][j]+" ");
                }
                System.out.println();
            }
        }





    }
}
