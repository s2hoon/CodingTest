package 그리디;
import java.util.*;
import java.io.*;
public class Main1802 {

    static String str ; 
    public static boolean recursive(int start, int end){
        if(start == end){
            return true;
        }
        int mid = (start + end ) /2;
        for(int i = start; i< mid ; i++){
            if(str.charAt(i)==str.charAt(end-i)){
                return false;
            }
        }
        return recursive(start, mid-1) && recursive(mid+1, end);

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0 ; test_case < T; test_case++){
            str = br.readLine();
            if(recursive(0, str.length()-1)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
