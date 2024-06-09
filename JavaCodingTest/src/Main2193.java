import java.util.*;
import java.io.*;

public class Main2193 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [][] dp = new long[91][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 2 ;i<91;i++){
            dp[i][0] = dp[i-1][1] + dp[i-1][0];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[N][1] + dp[N][0]);
        
    }
}
