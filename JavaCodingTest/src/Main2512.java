import java.util.*;
import java.io.*;
public class Main2512 {
    static int N;
    static int tot;
    static int [] arr;
    static int result = -1;

    public static void parametic(int left, int right){

        while(left <= right){
            int mid = (left + right) /2;
            
            int sum =0;
            for(int i =0 ;i<N; i++){
                if(arr[i] >= mid){
                    sum += mid;
                }
                else{
                    sum += arr[i];
                }
            } 

            if(sum > tot){
                right = mid -1;
                
            }else{
                result = mid;
                left = mid +1;
            }
        
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 1;
        for(int i =0 ;i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(arr[i],right);
            result = Math.max(result, right);
        }
        tot = Integer.parseInt(br.readLine());
        parametic(left, right);

        System.out.println(result);
    }
}
