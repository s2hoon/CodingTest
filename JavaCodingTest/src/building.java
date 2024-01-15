import java.util.*;
import java.io.*;

public class building {


    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int test_case =1; test_case<T+1; test_case++){
            List<Integer> results = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String [][] graph = new String[N][N];
            for(int i =0; i< N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0; j< N ;j++){
                    graph[i][j] = st.nextToken();
                }
            }
   
            for(int i =0; i< N ; i++){
                for(int j =0; j<N ;j++){
                    if(graph[i][j].equals("B")){
                        boolean flag = false;
                        for(int k =0 ; k<8 ;k++){
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if(nx >= N || nx <0 || ny>=N|| ny<0){
                                continue;
                            }
                            if(graph[nx][ny].equals("G")){
                                results.add(2);
                                flag = true;
                                break;
                            }
                        }

                        if(flag == false){
                            int temp = 0;
                            for(int row =0 ; row <N; row++){
                                if(graph[row][j].equals("B")){
                                    temp +=1;
                                }
                            }
                            for(int col =0 ; col <N; col++){
                                if(graph[i][col].equals("B")){
                                    temp +=1;
                                }
                            }
                            results.add(temp-1);
                        }

                    }
        
                }
            }

            System.out.printf("#%d %d",test_case , Collections.max(results));
            System.out.println();
        }

        
    }
}
