import java.io.*;
import java.util.*;
public class Main1952 {
    

    static int[] ticket = new int[4];
    static int[] arr =new int[13];
    static List<Integer> results;

    public static void recursive(int r , int money){

        if( r >= 13){
            results.add(money);
            return;
        }

        if(arr[r] !=0){
            // 1일치 이용권
            recursive(r+1, money+ticket[0]*arr[r]);
            // 1달 이용권
            recursive(r+1, money+ticket[1]);

            // 3달 이용권
            recursive(r+3, money+ticket[2]);
           
            // 1년 이용권
            recursive(r+12, money+ticket[3]);
            
        }else{
            recursive(r+1, money);
        }

    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int test_case =0 ; test_case <T; test_case++){
            st = new StringTokenizer(br.readLine());
            for(int i =0;i< 4; i++){
                ticket[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i =1;i<13; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            results = new ArrayList<>();
            recursive(1,0);
            System.out.println("#"+(test_case+1)+" "+Collections.min(results));
        }


       

    }
}
