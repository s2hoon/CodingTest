package 그리디;
import java.util.*;
import java.io.*;
public class Main1543 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String word = br.readLine();
        int left = 0;
        int right = word.length();
        int cnt = 0;
        while(right <= str.length()){
            if(str.substring(left, right).equals(word)){
                left = right;
                right = left + word.length();
                cnt+=1;
            }else{
                left +=1;
                right +=1;
            }
        }
        System.out.println(cnt);
    }
}
