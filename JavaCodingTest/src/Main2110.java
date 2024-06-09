import java.util.*;
import java.io.*;

public class Main2110 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        int left = 0;
        int right = 1_000_000_000;
        int answer = 0;
        for(int i =0 ;i< N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        while(left <= right){
            int mid = (left + right)/2;
            int temp = arr[0];
            int cnt = 1;
            for(int i = 1 ;i< arr.length; i++){
                if(arr[i]-temp >= mid){
                    temp = arr[i];
                    cnt +=1;
                }
            }
            if(cnt >= C){
                answer = mid;
                left = mid +1;
          
            }else{
                
                right = mid -1;
            }
            
        }
        System.out.println(answer);
    
    
    }
}
