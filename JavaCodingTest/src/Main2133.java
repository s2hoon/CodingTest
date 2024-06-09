import java.util.*;
import java.io.*;
public class Main2133 {
    

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int[] dp= new int[31];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;

        for(int i =4;i<N+1; i++){
            dp[i] = dp[i-2] *3;
            
            for(int j =i-4;j>=0;j-=2){
                dp[i] += dp[j]*2;
            }

        }
        System.out.println(dp[N]);
        String s ="fsear";
        System.out.println(s.substring(0,3));
        System.out.println(s.charAt(2));

    }

}
