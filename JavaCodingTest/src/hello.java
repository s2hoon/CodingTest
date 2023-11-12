import java.util.*;
import java.io.*;

public class hello {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        String[] numbers = br.readLine().split(" ");
        List<String> answer = new ArrayList<>();

       
        for (String number : numbers){
            if (Integer.parseInt(number) < X){
                answer.add(number);
            }
        }
        
        for( String number: answer){
            System.out.print(number+" ");
        }

    }


    
}
