import java.util.*;
import java.io.*;


public class p14500 {


    static int N;
    static int M;
    static int [][] graph;
    static class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
   
    static int answer =0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Set<Point> pset = new HashSet<>();
    public static void DFS(Point p , int cnt, int sum){

        if(cnt == 0){
            answer = Math.max(sum, answer);
            return;
        }
        pset.add(p);
        for(int i = 0 ; i< 4;i++){
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if(nx >= N || nx <0 || ny >= M || ny<0 || pset.contains(new Point(nx,ny))){
                continue;
            }
            Point temp = new Point(nx,ny);
            DFS(new Point(nx, ny), cnt-1, sum+graph[nx][ny]);
          
        }
         pset.remove(p);

    }


    public static void recursive(Point p ){
        int temp =graph[p.x][p.y];
         for(int i = 0 ; i< 4;i++){
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if(nx >= N || nx <0 || ny >= M || ny<0 ){
                continue;
            }
            if(nx ==p.x +1 && ny==p.y){
                continue;
            }
            temp += graph[nx][ny];
        }
        answer = Math.max(answer, temp);
        temp = graph[p.x][p.y];
        for(int i = 0 ; i< 4;i++){
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if(nx >= N || nx <0 || ny >= M || ny<0 ){
                continue;
            }
            if(nx ==p.x -1 && ny==p.y){
                continue;
            }
            temp += graph[nx][ny];
        }
        answer = Math.max(answer, temp);
        temp = graph[p.x][p.y];
        for(int i = 0 ; i< 4;i++){
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if(nx >= N || nx <0 || ny >= M || ny<0 ){
                continue;
            }
            if(nx ==p.x  && ny==p.y+1){
                continue;
            }
            temp += graph[nx][ny];
          
        }
        answer = Math.max(answer, temp);
        temp = graph[p.x][p.y];
        for(int i = 0 ; i< 4;i++){
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if(nx >= N || nx <0 || ny >= M || ny<0 ){
                continue;
            }
            if(nx ==p.x  && ny==p.y-1){
                continue;
            }
            temp += graph[nx][ny];
        
        }
        answer = Math.max(answer, temp);
        temp = graph[p.x][p.y];
        
 
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


        for(int i =0; i< N;i++){
            for(int j=0; j<M; j++){
                DFS(new Point(i,j), 3, graph[i][j]);
            }
        }

          for(int i =0; i< N;i++){
            for(int j=0; j<M; j++){
                recursive(new Point(i,j));
            }
        }
       
       
        System.out.println(answer);




    }
}
