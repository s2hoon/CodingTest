import java.util.*;
import java.io.*;

public class Main14238 {
    

    static int[][][][][] dp;
    static boolean flag =false;
 

    static void recursive(int a, int b, int c, int pre2, int pre, String result){


        if(flag ==true){
            return;
        }

        if(dp[a][b][c][pre2][pre]!=0){
            return;
        }

        if(a==0 && b==0 && c==0){
            System.out.println(result);
            flag = true;
            return;
        }
        
        dp[a][b][c][pre2][pre] = 1;

        if(a > 0){
            recursive(a-1,b,c,pre,1,result+"A");
        }
        if( b> 0 && pre != 2){
            recursive(a,b-1,c, pre,2,result+"B");
        }
        if(c >0 && pre != 3 && pre2 != 3){
            recursive(a,b,c-1,pre,3,result+"C");
        }

    }

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split("");
        int a=0;
        int b=0;
        int c=0;
        for(String s : S){
            if(s.equals("A")){
                a+=1;
            }
            if(s.equals("B")){
                b+=1;
            }
            if(s.equals("C")){
                c+=1;
            }
        }

        dp = new int[a+1][b+1][c+1][4][4];
        recursive(a, b, c, 0, 0, "");

        if(flag == false){
            System.out.println(-1);
        }


    }
}
