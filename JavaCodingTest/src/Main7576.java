import java.util.*;
import java.io.*;
public class Main7576 {
    static int M;
    static int N;
    static int[][] graph;
    static int [] dx ={0,1,0,-1};
    static int [] dy ={1,0,-1,0};

    public static int BFS(Queue<int[]> tomato){
       
        Queue<int[]> temp = new LinkedList<>();
        int cnt = 0;

        while(!tomato.isEmpty()){
            int []t = tomato.poll();
            for(int i =0;i<4; i++){
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];
                if(nx >= N || nx<0 || ny>= M || ny<0){
                    continue;
                }
                
                if(graph[nx][ny]==0){
                    graph[nx][ny] = 1;
                    temp.add(new int[]{nx,ny});
                }

            }

            if(tomato.isEmpty()){
                cnt +=1;
                tomato = temp;
                temp = new LinkedList<>();
            }

        }
        
        return cnt;

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        Queue<int[]> tomato = new LinkedList<>();
        for(int i =0 ;i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1){
                    tomato.add(new int[]{i,j});
                }
            }
        }
        if(tomato.size()==N*M){
            System.out.println(0);
            return;
        }
        int result = BFS(tomato);
        boolean flag = true;
        for(int i =0 ;i< N; i++){
            for(int j =0 ;j<M; j++){
                if(graph[i][j] == 0){
                    flag =false;
                    break;
                }
            }
        }
   
        if(flag==false){
            System.out.println(-1);
        }else{
            System.out.println(result-1);
        }

    }
}
