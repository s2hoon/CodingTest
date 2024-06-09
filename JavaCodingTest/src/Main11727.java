import java.util.*;
import java.io.*;
public class Main11727 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for(int i =3;i<1001;i++){
            dp[i] = (dp[i-1] + dp[i-2] * 2)%10007;
        }   
        System.out.println(dp[n]%10007);



    }
}
