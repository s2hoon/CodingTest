import java.util.*;
import java.io.*;
public class Main11501 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        for(int test_case =0;test_case <T; test_case ++){
            int N = Integer.parseInt(br.readLine());
            long [] arr = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int i =0 ;i< N; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
         
            long [] dp = new long[N];
            long temp = arr[N-1];
            dp[N-1] = temp;
            for(int i = N-2;i>-1;i--){
                if(arr[i]<temp){
                    dp[i] =temp;
                }else{
                    temp = arr[i];
                    dp[i] = temp;
                }
            }
            long sum =0;
            for(int i =0;i< N; i++){
                sum += (dp[i]-arr[i]);
            }
            System.out.println(sum);
        }
    }
}
