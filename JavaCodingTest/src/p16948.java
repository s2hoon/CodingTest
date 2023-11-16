import java.util.*;
import java.io.*;

public class p16948 {
    
    static int N;
    static boolean[][] visited;
    static int[] dx = new int[] {2, 2, 0, -2,-2,  0};
    static int[] dy = new int[] {1,-1,-2, -1, 1,  2};
    static List<Integer> result = new ArrayList<>();

    public static int BFS(int r1, int r2, int r3, int r4){
        visited = new boolean[N][N];
        visited[r1][r2] =true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r1,r2,0});
        while(queue.peek()!=null){
            int[] node =queue.poll();
            if(node[0] == r3 && node[1] == r4){
                return node[2];
            }
            for (int i =0; i<6; i++){
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                if(nx >= N || nx <0 || ny >=N || ny <0){
                    continue;
                }
                else{
                    if(visited[nx][ny]==false){
                        queue.add(new int[]{nx,ny,node[2]+1});
                        visited[nx][ny] = true;
                    }

                }




            }
            




        }
        return -1;
    }



    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r1 =0;
        int r2 =0;
        int r3 =0;
        int r4 =0;
            r1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            r3 = Integer.parseInt(st.nextToken());
            r4 = Integer.parseInt(st.nextToken());


        int answer = BFS(r1,r2,r3,r4);
        if(answer == -1){
            System.out.println(-1);
        }
        else{
        System.out.println(answer);
        }



    }
}
