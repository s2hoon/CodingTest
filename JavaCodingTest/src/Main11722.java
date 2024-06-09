import java.util.*;
import java.io.*;


public class Main11722 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[N+1];
        for(int i =1 ;i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N+1];
        int result = 1;
        dp[1] = 1;
        for(int i = 2; i< N+1; i++){
            dp[i] = 1;
            for(int j = 1;j<i;j++){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        System.out.println(result);

    
    }
}
