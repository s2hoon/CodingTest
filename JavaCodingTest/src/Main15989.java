import java.util.*;
import java.io.*;
public class Main15989 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int [][] dp = new int[10001][4];
        dp[1][1] =1;
        dp[2][1] =1;
        dp[2][2] =1;
        dp[3][1] =1;
        dp[3][2] =1;
        dp[3][3] =1;

        for(int i =4;i<10001;i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1]+ dp[i-2][2];
            dp[i][3] = dp[i-3][1] +dp[i-3][2]+dp[i-3][3];
        }


        for(int test_case=0 ; test_case<T; test_case++){
            int n = Integer.parseInt(br.readLine());
            int result = 0;
            for(int k =1 ;k<4; k++){
                result += dp[n][k];
            }

            System.out.println(result);

        }



    }
}
