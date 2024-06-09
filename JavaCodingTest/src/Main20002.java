import java.util.*;
import java.io.*;

public class Main20002 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] graph = new int[N][N];
        StringTokenizer st;
        for(int i =0 ;i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] dp = new int[N][N];
        dp[0][0] = graph[0][0];
        for(int i =1 ;i<N; i++){
            dp[0][i] = dp[0][i-1] + graph[0][i];
        }
        for(int i =1 ;i<N; i++){
            dp[i][0] = dp[i-1][0] + graph[i][0];
        }

        for(int i =1 ;i<N; i++){
            for(int j =1;j<N; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + graph[i][j];
            }
        }
        int result = -1000;
        for(int i = 0;i<N; i++){
            for(int j =0;j<N; j++){
                for(int k =0 ;k<N; k++){
                    int x1 = i;
                    int y1 = j;
                    int x2 = i + k;
                    int y2 = j + k;
                    if(x2 >= N || x2 <0 || y2 >= N || y2 <0){
                        continue;
                    }
                    int t = dp[x2][y2];
                    int cnt = 0;
                    if(x1!=0){
                        cnt +=1;
                        t -= dp[x1-1][y2];
                    }
                    if(y1!=0){
                        cnt +=1;
                        t -= dp[x2][y1-1];
                    }
                    if(cnt == 2){
                        t += dp[x1-1][y1-1];
                    }
                    // int t = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
                    result = Math.max(t,result);


                }
            }
        }

   
        System.out.println(result);

        
    }
}
