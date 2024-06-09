import java.util.*;
import java.io.*;

public class Main14722 {
    
    static int N;
    static int [][] graph;
    static int [][][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        dp = new int[N+1][N+1][3];
        for(int i = 1 ;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1;j<N+1; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] ==0){
                    dp[i][j][0] =1;
                }
            }
        }
        for(int i=1;i<N+1; i++){
            for(int j=1;j<N+1; j++){
                for(int k =0;k<3; k++){
                    dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j][k]);
                    dp[i][j][k] =  Math.max(dp[i][j][k], dp[i][j-1][k]);
                    int t;
                    if(graph[i][j] ==k){
                        if(k == 0){
                            t = 2;      
                        }else{
                            t = k-1;
                        }
                        if(dp[i-1][j][t]!=0){
                            dp[i][j][k] = Math.max(dp[i-1][j][t]+1,dp[i][j][k]);
                        }
                        if(dp[i][j-1][t]!=0){
                            dp[i][j][k] = Math.max(dp[i][j-1][t]+1,dp[i][j][k]);
                        }
                    }
                
                }   
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        int result  = 0;
        for(int i = 0;i< 3;i++){
            result = Math.max(dp[N][N][i],result);
        }
        System.out.println(result);

    }

}