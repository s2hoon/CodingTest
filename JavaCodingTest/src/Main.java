import java.io.*;
import java.util.*;
class Main {

 
    static int M;
    static int[] arr1 = new int[M];
    static int[] arr2 = new int[M];
    static List<String> results;

	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
        arr1 = new int[M];  // Initialize arr1 after getting the value of M
        arr2 = new int[M];  // Initialize arr2 after getting the value of M
        results = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<M ;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int temp2 =Integer.parseInt(br.readLine());
        
       
        
        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i<cnt; i++){
            temp2 +=1;
            for(int j= 0; j< M ;j++){
                if(temp2 % Math.pow(10,j) == arr1[j] ){
                    temp2 -= arr1[j];
                    temp2 += Math.pow(10,M-j);
                }
            }

            results.add(Integer.toString(temp2));
        }


        System.out.println(results);





	
    }

}