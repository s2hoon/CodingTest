import java.util.*;
import java.io.*;
public class Main2812 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k =M;
        String[] num = br.readLine().split("");
        Stack<Integer> stack = new Stack<>();
        for(int i =0 ;i<N; i++){
         
            while(M>=1 && !stack.isEmpty() && stack.peek() < Integer.parseInt(num[i])){
                stack.pop();
                M-=1;
            }
            stack.add(Integer.parseInt(num[i]));
                
        }

        
        int cnt = N-k;
        for(Integer t : stack){
            System.out.print(t);
            cnt -=1;
            if(cnt ==0 ){
                break;
            }
        }

    }
}
