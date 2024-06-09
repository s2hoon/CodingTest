import java.util.*;
import java.io.*;
public class Main1699 {
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        
        dp[1] = 1;
        for(int i =2; i< N+1; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        System.out.println(dp[N]);

    }
}
