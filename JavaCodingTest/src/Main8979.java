import java.util.*;
import java.io.*;
public class Main8979 {
    public static class Nation implements Comparable<Nation>{

        int gold;
        int silver;
        int dong;
        public Nation(int gold, int silver, int dong){
            this.gold = gold;
            this.silver = silver;
            this.dong = dong;
        }
        @Override
        public int compareTo(Nation o) {
            if(this.gold != o.gold){
                return o.gold - this.gold;
            }
            if(this.silver != o.silver){
                return o.silver - this.silver;
            }
            if(this.dong != o.dong){
                return o.dong - this.dong;
            }
            return 0;
        
        }
        @Override
        public String toString() {
            return "Nation [gold=" + gold + ", silver=" + silver + ", dong=" + dong + "]";
        }
        
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int t1=0;
        int t2 = 0;
        int t3 = 0;
        List<Nation> list = new ArrayList<>();
        for(int i =0 ;i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(a==K){
                t1 = g;
                t2 = s;
                t3 = d;
            }
            Nation t = new Nation(g,s,d);
            list.add(t);
        }
        
            Collections.sort(list);
            int result = 0;
            for(int j =0 ;j< list.size();j++){
                if( t1 == list.get(j).gold && t2 == list.get(j).silver && t3 == list.get(j).dong){
                    break;
                }else{
                    result+=1;
                }
            }
            System.out.println(result+1);

            

    }
}
