package 그리디;

import java.util.*;
import java.io.*;
public class Main2012 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for(int i=0;i< N; i++ ){
            arr[i] = Integer.parseInt(br.readLine());
       
        }
        Arrays.sort(arr);
        long sum =0 ;
        for(int i =0 ;i< N; i++){
            sum +=Math.abs(arr[i]-(i+1));
        }
        System.out.println(sum);
    }
}
