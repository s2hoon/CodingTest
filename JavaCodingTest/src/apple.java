import java.util.*;
import java.io.*;
public class apple {
    
    static int N;
    static int [][] graph;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static List<Integer> results;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for(int i =0; i< N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j< N ; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }  
        results = new ArrayList<>();

        for(int x = 0 ; x< N ;x++){
            for(int y =0; y< N; y++){
                int sum  = graph[x][y];
                for(int k = 0; k< 4;k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx>=N || nx <0 || ny>=N || ny<0){
                        continue;
                    }
                    sum += graph[nx][ny];
                    results.add(sum);
                }
            }
        }
        System.out.println(Collections.max(results));

        }


}



