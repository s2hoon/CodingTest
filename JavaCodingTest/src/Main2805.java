import java.util.*;
import java.io.*;
public class Main2805 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr =new int[N];
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;
        int result = 0;
        for(int i =0 ;i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        while(left<=right){

            int mid = (left +right)/2;

            long sum = 0;
            for(int i =0 ;i< N; i++){
                if(mid < arr[i]){
                    sum += arr[i] - mid;
                }
            }
            if(sum >= M){
                result = mid;
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        System.out.println(result);





    }
}
