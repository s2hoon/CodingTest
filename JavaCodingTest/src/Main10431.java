import java.util.*;
import java.io.*;
public class Main10431 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int test_case = 1 ;test_case <= T; test_case ++){
            List<Integer> people = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int tt = Integer.parseInt(st.nextToken());
            int result = 0;
            for(int i =0 ;i< 20 ;i++){
                int a = Integer.parseInt(st.nextToken());
                if(people.isEmpty()){
                    people.add(a);
                }else{
                    int cnt = 0;
                    for(int j=people.size()-1; j >= 0; j--){
                        if(people.get(j)>a){
                            cnt+=1;
                        }
                    }
                    people.add(a);
                    result = cnt + result;
                }
                Collections.sort(people);
            }
            System.out.println(tt+" "+result);

        }
    }
}
