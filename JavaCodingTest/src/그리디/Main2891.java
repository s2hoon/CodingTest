package 그리디;

import java.util.*;
import java.io.*;
public class Main2891 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        Set<Integer> broked = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < S; i++){
            broked.add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> more = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i =0 ;i< R; i++){
            int k = Integer.parseInt(st.nextToken());
            if(!broked.contains(k)){
                more.add(k);
            }else{
                broked.remove(k);
            }
        }
        int result = broked.size();
        List<Integer> list = new ArrayList<>(more);
        for(int i =0 ;i < list.size(); i++){
            if(broked.contains(list.get(i)-1)){
                broked.remove(list.get(i)-1);
                result -=1;
            }
            else if(broked.contains(list.get(i)+1)){
                broked.remove(list.get(i)+1);
                result -=1;
            }
        }
        System.out.println(result);

    }
}
