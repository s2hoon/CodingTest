
import java.util.*;
import java.io.*;


public class flatten {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:/codingtest/CodingTest/JavaCodingTest/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int test_case =0; test_case<10; test_case++){
            st = new StringTokenizer(br.readLine());
            int dump = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int [] arr = new int[100];
            for(int i=0; i< 100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        
            Arrays.sort(arr);   
    
            while(dump>0){
                int startIdx = 0;
                int endIdx = arr.length-1;
                while(startIdx < arr.length-1){
                   if(arr[startIdx]==0){
                    startIdx+=1;
                   }else{
                    break;
                   }
                }
                while(endIdx>0){
                    if(arr[endIdx]==0){
                        endIdx-=1;
                    }else{
                        break;
                    }

                }
                arr[startIdx]+=1;
                arr[endIdx]-=1;
                Arrays.sort(arr);
                dump-=1;
            }
            System.out.println("#"+(test_case+1)+" "+ (arr[arr.length-1]-arr[0]));
        }


        // while(dump>0){




        //     dump-=1;
        // }




    }


}
