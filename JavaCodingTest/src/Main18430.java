import java.util.*;
import java.io.*;
public class Main18430 {
    static int N;
    static int M;
    static int [][] graph;
    static int [][] dx ={{0,1,0},{0,0,-1},{0,-1,0},{0,0,1}};
    static int [][] dy ={{0,0,-1},{0,-1,0},{0,0,1},{0,1,0}};
    static boolean [][] visited;
    static int result  =0;

    public static void recursive(Queue<int[]> queue, int sum){
  
        if(queue.isEmpty()){
            result = Math.max(sum, result);
            return;
        }
        int[] t =queue.poll();
        Queue<int[]> next_queue = new LinkedList<>();
        for (int[] item : queue) {
            next_queue.offer(new int[] { item[0], item[1] }); // queue의 요소를 복사하여 next_queue에 추가
        }
        // 안함
        recursive(next_queue, sum);
      
        // 4가지 방법으로 ㄱ
        for(int i =0 ;i< 4; i++){
            boolean ifcan = true;
            List<int[]> t_list = new ArrayList<>();
            for(int j =0 ;j< 3; j++){
                int nx = t[0] + dx[i][j];
                int ny = t[1] + dy[i][j];
                if(nx >= N|| nx <0 || ny >= M || ny<0){
                    ifcan = false;
                    break;
                }
                if(visited[nx][ny]==true){
                    ifcan = false;
                    break;
                }
                t_list.add(new int[]{nx,ny});
            }
            if(ifcan==true){
                int tsum = graph[t[0]][t[1]];
                for(int[]k : t_list){
                    visited[k[0]][k[1]]=true;
                    tsum += graph[k[0]][k[1]];
                }
                recursive(next_queue, sum+tsum);
                for(int[]k : t_list){
                    visited[k[0]][k[1]]=false;
                }
            }
        }
            
    }
         
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        for(int i =0 ;i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ;j<M ;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                queue.add(new int[]{i,j});
            }
        }
        recursive(queue, 0);
        System.out.println(result);
    }
}
