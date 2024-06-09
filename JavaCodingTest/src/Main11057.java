import java.util.*;
import java.io.*;
public class Main11057 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  N = Integer.parseInt(br.readLine());
        int [][] dp = new int[N+1][10];
        dp[1] = new int [] {1,1,1,1,1,1,1,1,1,1};

        for(int i = 2;i< N+1; i++){
            for(int j = 0;j<10;j++){
                for(int k =0 ;k<j+1; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] = dp[i][j]% 10007;
                }
            }
        }

        int result = 0;
        for(int i = 0;i< 10; i++){
            result  += dp[N][i];
            result = result % 10007;
        }
        System.out.println(result % 10007);
    }
}
