import java.util.*;
import java.io.*;

public class Main1912 {




    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] dp = new int[n+1];
        int[] arr = new int[n+1];
        for(int i =1 ;i< n+1; i++){
            arr[i]  = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        int result = arr[1];
        for(int i =2;i<n+1; i++){
            dp[i] = Math.max(dp[i-1] + arr[i] , arr[i]);
            result = Math.max(result, dp[i]);
        }
      
        System.out.println(result);
        



    }
}
