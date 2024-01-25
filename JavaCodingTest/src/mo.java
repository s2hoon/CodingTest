
import java.util.*;
import java.io.*;
public class mo{
    
    static int N;
    static int M;
    static int D;
    static int [][] graph;
    static boolean [] v;
    static boolean [][] visited;
    static boolean [][] visited2;
    static int [] dx = {0,-1,0,1};
    static int [] dy = {-1,0,1,0};
    static int result;
    static int final_result;

    public static void go(){

        for(int i=0; i< N; i++){
            for(int j=0; j< M; j++){
                if(graph[i][j] == -1){
                    graph[i][j] = 0;
                }
            }
        }

        for(int i =N-1; i>0 ;i--){
            for(int j =0; j< M ;j++){
                graph[i][j] = graph[i-1][j];
            }
        }
    }

    public static void BFS(int x , int y, int distance) {

        visited[x][y] =true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y, distance});
        while(queue.size()!=0) {
            int []t =queue.poll();
            for(int i =0; i< 4; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];
                if(nx >=N+1 || nx<0 || ny>=M || ny<0 || t[2] >= D || nx == x) {
                    continue;
                }

                if(t[2] <= D-1 && graph[nx][ny] == 1 || graph[nx][ny] == -1){
                    if(visited2[nx][ny] ==false){
                        visited2[nx][ny] = true;
                        result +=1;
                        graph[nx][ny] =-1;
                        System.out.println(result);
                        return;
                    }
                    return;
                }

                if(visited[nx][ny] ==false && graph[nx][ny] == 0){
                    System.out.println(nx+ " " +ny);
                    queue.add(new int[] {nx,ny,t[2]+1});
                    visited[nx][ny] = true;
                }
        
            }
        }
        return ;
       
        
    }
    
    public static void combination(int r, int start , List<Integer> temp, List<List<Integer>> archors) {
        if( r== 3) {
            archors.add(new ArrayList<>(temp));
            return;
        }
        for(int i =start; i< M; i++ ) {
            if(v[i]==false) {
                v[i] =true;
                temp.add(i);
                combination(r+1,i+1, temp, archors);
                temp.remove(temp.size()-1);
                v[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            v = new boolean[M];
            graph = new int[N+1][M];
            for(int i =0 ; i< N ;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j =0; j< M ; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            List<Integer>temp = new ArrayList<>();
            List<List<Integer>> archors = new ArrayList<>();
            int finalr = 0;
            visited2 = new boolean[N][M];
            for(List<Integer> t : archors) {
                result = 0;
                int p = N;
                while(p==0){
                for(int i =0; i< 3; i++){
                    visited = new boolean[N][M];
                    BFS(N, t.get(i),0);
                }
                visited2 = new boolean[N][M];
                go();
                p--;
                }
                finalr = Math.max(result, finalr);
            }
            System.out.println(finalr);

        }
            
}