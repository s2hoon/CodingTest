import java.util.*;
import java.io.*;
public class p15658 {

    static int N;
    static int [] A;
    static List<Integer> results;

    public static void recursive(int a,int b, int c, int d, int cnt, int sum, int index){
        
        if(index == N){
            results.add(sum);
            return;
        }

        if( a > 0){
            recursive(a-1, b, c, d, cnt-1, sum+A[index], index+1);
        }
        if( b > 0){
            recursive(a, b-1, c, d, cnt-1, sum-A[index], index+1);
        }
        if( c > 0){
            recursive(a, b, c-1, d, cnt-1, sum*A[index], index+1);
        }
        if( d > 0){
            if(sum<0){
                recursive(a, b, c, d-1, cnt-1, -((-sum)/A[index]), index+1);
            }else{
                recursive(a, b, c, d-1, cnt-1, sum/A[index], index+1);
            }
        }
        return;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i = 0; i< N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        results = new ArrayList<>();
        recursive(a,b,c,d,N-1,A[0],1);

        System.out.println(Collections.max(results));
        System.out.println(Collections.min(results));
    }
    
}
