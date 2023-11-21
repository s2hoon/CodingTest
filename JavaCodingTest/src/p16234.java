import java.util.*;
import java.io.*;


class Point{
        public int x;
        public int y;

        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

}

public class p16234 {
    

    static int N ;
    static int L;
    static int R;
    static int [][] graph;
    static boolean [][] visited ;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static ArrayList<Point> list;

    public static int DFS(Point p,int sum){
 
        visited[p.x][p.y] = true;
        list.add(new Point(p.x,p.y));
        for(int i =0; i<4;i++){
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            
            if(nx>=N || nx<0 || ny>=N || ny<0){
                continue;
            }
            int diff =Math.abs(graph[p.x][p.y] - graph[nx][ny]);
            if(visited[nx][ny]==false && diff>=L && diff <=R){
                sum =  DFS(new Point(nx,ny), sum +graph[nx][ny]);
           
            }

        }

        return sum;

    }


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for (int i = 0; i< N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N ;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        boolean moved = true;
        int answer =0 ;
        while(moved){
            moved = false;
            answer+=1;
            visited = new boolean[N][N];
            for(int i =0;i<N;i++){
                for(int j=0 ; j<N;j++){
                    visited[i][j] = false;
                }
            }

    
            for(int i =0; i< N ;i++){
                for(int j=0; j< N ;j++){
                        if( visited[i][j] == false){
                            list  = new ArrayList<>();
                            int result = DFS(new Point(i,j),graph[i][j]);
        
                            for(Point p : list){
                            graph[p.x][p.y] = result/list.size();

                            if(list.size()>1){
                                moved = true;
                                
                            }
                        }
                    }
                }
            }

        }

        System.out.println(answer-1);

    }
}
