import java.util.*;
import java.io.*;
public class Main25757 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String t = st.nextToken();
      
        HashSet<String> person = new HashSet<>();
        for(int i =0 ;i< N; i++){
            person.add(br.readLine());
        }
        int cnt = 0;
        if(t.equals("Y")){
            cnt = person.size() /1;
        }
        if(t.equals("F")){
            cnt = person.size()/2;
        }
        if(t.equals("O")){
            cnt = person.size()/3;
        }
        System.out.println(cnt);
    }

}
