import java.util.*;
import java.io.*;
public class p11066 {




    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int S =0; S< T ;S++){
            int K = Integer.parseInt(br.readLine());
            int []arr = new int[K+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<= K ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int [] Sum = new int[K+1];
            int [][] dp = new int[K+1][K+1];

            for(int i =1 ; i<=K; i++){
                Sum[i] = Sum[i-1] + arr[i];
            }

            

            for (int n = 1; n <= K; n++) {  //부분 배열의 길이
                for (int i = 1; i + n <= K; i++) {
                    int j = i + n;
                    dp[i][j] = Integer.MAX_VALUE; 
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + Sum[j] - Sum[i - 1]);
                    }
                }
            }
            System.out.println(dp[1][K]);
           

        }



    }
    
}
