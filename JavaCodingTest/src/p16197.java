import java.util.*;
import java.io.*;
public class p16197 {
    static int N;
    static int M;
    static String[][] graph;

    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static List<Integer> results;

    static class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int recursive(Point p1, Point p2 , int answer){
        // 불가능 한 경우 -> 11번째 시도
        if (answer == 11){
            return -1;
        }
        boolean fall1 = false;
        boolean fall2 = false;
   
        if (p1.x >= N ||p1.x <0 || p1.y >= M || p1.y < 0){
            fall1 = true;
        }
       
       
        if ( p2.x >= N ||p2.x <0 || p2.y >= M || p2.y < 0) {
            fall2 = true;
        }
         // 불가능 한 경우 -> 둘다 떨어짐
        if (fall1 && fall2 ) return -1;
        // 내가 찾는 상황 -> 동전이 하나가 됬을 경우
        if (fall1 || fall2 ){
            results.add(answer);
            return answer;
        }
    
   
        for (int i =0; i< 4 ;i++){
            int nx1 = p1.x + dx[i];
            int ny1 = p1.y + dy[i];
            int nx2 = p2.x + dx[i];
            int ny2 = p2.y + dy[i];
            
            if (nx1 < N  && nx1 >= 0 && ny1 < M && ny1 >= 0 && graph[nx1][ny1].equals("#") ){
                nx1 = p1.x;
                ny1 = p1.y;
            }
       
            if (nx2 < N  && nx2 >= 0 && ny2 < M && ny2 >= 0 && graph[nx2][ny2].equals("#") ){
                nx2 = p2.x;
                ny2 = p2.y;
            }
            Point np1 = new Point(nx1,ny1);
            Point np2 = new Point(nx2,ny2);
            
            recursive(np1, np2, answer+1);
       

        }
      
        return answer;
      
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[N][M];

        List<Point> coins = new ArrayList<>();

        for(int i=0; i< N; i++){
            String[] line =br.readLine().split("");
            for(int j = 0; j< M ; j++){
                graph[i][j] = line[j];
                if(graph[i][j].equals("o")){
                    coins.add(new Point(i,j));
                }
            }
        }
     

        Point p1 = new Point(coins.get(0).x, coins.get(0).y);
        Point p2 = new Point(coins.get(1).x, coins.get(1).y);


        results = new ArrayList<>();
        recursive(p1, p2 , 0);

        System.out.println(Collections.min(results));





    }


}