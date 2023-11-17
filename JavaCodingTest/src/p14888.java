
import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int [] nums;
    static List<Integer> listf = new ArrayList<>();


    public static void recursive(int start , int result, int[] cc){

        if(cc[0]==0 && cc[1] == 0 && cc[2]==0 && cc[3] ==0){
            listf.add(result);
            return;
        }

        if(cc[0]!=0){
            int[] c2 = new int[4];
            for (int i =0; i< 4;i++){
                c2[i] = cc[i];
            }
            c2[0] -=1;
            recursive(start+1, result+nums[start],c2);
        }

        if(cc[1]!=0){
             int[] c2 = new int[4];
            for (int i =0; i< 4;i++){
                c2[i] = cc[i];
            }
            c2[1] -=1;
            recursive(start+1, result-nums[start],c2);
        }
         if(cc[2]!=0){
             int[] c2 = new int[4];
            for (int i =0; i< 4;i++){
                c2[i] = cc[i];
            }
            c2[2] -=1;
            recursive(start+1, result*nums[start],c2);
        }
            if(cc[3]!=0){
             int[] c2 = new int[4];
            for (int i =0; i< 4;i++){
                c2[i] = cc[i];
            }
            c2[3] -=1;
            if(result <0){
                recursive(start+1, -((-result)/nums[start]),c2);
            }else{
                recursive(start+1, result/nums[start],c2);
            }
        }
       return;
        


    }
  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums= new int[N];
        for (int i= 0; i< N ;i++){
            nums[i] = (Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        int[] cc = new int[4];
        for(int i =0 ;i<4;i++){
            cc[i] = (Integer.parseInt(st.nextToken()));
        }
       
       recursive(1,nums[0],cc);
       System.out.println(Collections.max(listf));
       System.out.println(Collections.min(listf));




    }
}
