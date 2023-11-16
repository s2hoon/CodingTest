import java.util.*;
import java.io.*;


public class p16928 {

 

    static int N;
    static int M;
    static int [] board = new int[101];
    static int [] visited = new int[101];
    
    public static void BFS(int start){

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 0;
        queue.add(start);
        while(queue.peek()!=null){
            int now =queue.poll();
            for(int i = 1;i <= 6; i++){
                int next = now +i;
                if( next >100){
                    continue;
                }
                next = board[next];
                if(visited[next]==-1){
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }


            }



        }




    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<101 ;i++){
            board[i] = i;
        }

        for(int i = 0; i<N ;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
         for(int i = 0; i<M ;i++){
             st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v;
        }

    

        for(int i=0 ; i< 101;i++){
            visited[i] = -1;
        }
        BFS(1);
        System.out.println(visited[100]);

            
    }
      


}
