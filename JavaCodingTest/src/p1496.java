import java.util.*;
import java.io.*;
public class p1496 {
    
    static int[] V;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        V = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1 ; i< N+1 ;i++){
            V[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1][M+1];
        dp[0][S] = 1;


        for(int i =0; i< N; i++){
            for(int j = 0 ; j< M+1; j++){
                if(dp[i][j] == 1){
                    if(j-V[i+1]>=0){
                        dp[i+1][j-V[i+1]] =1;
                    }
                    if( j+V[i+1] <= M){
                        dp[i+1][j+V[i+1]] =1;
                    }
                }
                
            }
        }

        int ans = -1;
        for(int i =0; i<= M ; i++){
            if (dp[N][i]==1){
                ans = i;
            }
        }

        System.out.println(ans);

        

    }
}
