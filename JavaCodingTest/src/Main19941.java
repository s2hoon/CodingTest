
import java.util.*;
import java.io.*;
public class Main19941 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String arr [] = br.readLine().split("");
        int cnt = 0;
        for(int i = 0;i < N; i++){
            if(arr[i].equals("P")){
                for(int j =i-K ;j< i+K+1; j++){
                    if(j < 0 || j>=N){
                        continue;
                    }
                   if(arr[j].equals("H")){
                        arr[j] = "1";
                        cnt +=1;
                        break;
                   }
                }   
            }
        }
    
        System.out.println(cnt);

    }
}
