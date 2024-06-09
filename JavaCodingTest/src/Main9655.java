import java.util.*;
import java.io.*;
public class Main9655 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println("SK");
            return;
        }else if( N==2 ){
            System.out.println("CY");
            return;
        }else if( N==3 ){
            System.out.println("SK");
            return;
        }
        else if( N==4 ){
            System.out.println("CY");
            return;
        }
        else if( N==5 ){
            System.out.println("SK");
            return;
        }
        else if( N==6 ){
            System.out.println("CY");
            return;
        }


        int [] dp = new int[N+2];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 0;
        dp[5] = 1;
        dp[6] = 0;
        for(int i =7; i<= N; i++){
            dp[i] = dp[i-4] | dp[i-2] | dp[i-6];
        }
        System.out.println(dp[N] == 1 ? "SK" : "CY");

    }
}
