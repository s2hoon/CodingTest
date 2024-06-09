import java.util.*;
import java.io.*;
public class Main23971 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cntX = 0;
        for(int i =1 ;i< H+1; i+=N+1){
            cntX +=1;
        }
        int cntY = 0;
        for(int i = 1;i <W+1; i+=M+1){
            cntY +=1;
        }
        System.out.println(cntX*cntY);
    }
}
