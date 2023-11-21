import java.io.*;
import java.util.*;
class p16198 {

    static List<Integer> goosel;
    static List<Integer> sums;
 
    static int N;


    public static void recursive(int answer){
        if (goosel.size() == 2){
            sums.add(answer);

        }


        for(int i =1 ; i< goosel.size()-1 ; i++){
            answer += goosel.get(i-1) * goosel.get(i+1);
            int temp =goosel.remove(i);
            recursive(answer);
            goosel.add(i,temp);
            answer -= goosel.get(i-1) * goosel.get(i+1);
        }
    

    }
    

	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        goosel = new ArrayList<>();
        for(int i=0; i< N ; i++){  
            goosel.add(Integer.parseInt(st.nextToken()));
        }

        sums = new ArrayList<>();
        recursive(0);
        
        System.out.println(Collections.max(sums));
	
    }

}