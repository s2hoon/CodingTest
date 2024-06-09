import java.util.*;
import java.io.*;
public class Main14852 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] dp = new long[N+1];
        long [] dp2 = new long[N+1];
        dp[0] = 1;
        dp[1] = 2; 
        dp[2] = 7;
        for(int i =3 ;i< N+1;i++){
            dp[i] = dp[i-1]*2%1_000_000_007 + dp[i-2] *3%1_000_000_007;
            dp2[i] += dp2[i-1] * dp[i];
            dp[i] += dp2[i-1] * 2 %1_000_000_007;
        }
        
        System.out.println(dp[N]%1_000_000_007);
    }
}

