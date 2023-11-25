import java.util.*;
import java.io.*;

public class p12865 {
    

    static int[] weight;
    static int[] value;
    static int[][] dp ;


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        weight = new int[N+1];
        value = new int[N+1];
        dp = new int[N+1][K+1];
        for(int i =1; i< N+1 ;i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =1; i < N+1 ;i++){
            for(int j =1; j< K+1 ; j++){
                if(j-weight[i] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);



    }
}
