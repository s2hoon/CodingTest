import java.util.*;
import java.io.*;
public class Main14002 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int [] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1 ;i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int [] dp = new int[N+1];
        dp[1] = 1;
        int lis = 1;
        for(int i=2 ;i< N+1; i++){
            dp[i] =1;
            for(int j = 1;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    lis = Math.max(lis,dp[i]);
                }
            }
        }

        System.out.println(lis);
        int t = lis;
        Stack<Integer> stack = new Stack<>();
        for(int i=N; i>0;i--){
            if(dp[i]==t){
                stack.add(arr[i]);
                t-=1;
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    
        
    }
}
