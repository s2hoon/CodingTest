
import java.util.*;
import java.io.*;
public class Main2655 {
    
    
    static class Box implements Comparable<Box>{
        int n ;
        int h ;
        int w ; 
        int num;
        public Box(int n, int h, int w, int num) {
            this.n = n;
            this.h = h;
            this.w = w;
            this.num = num;
        }
        @Override
        public int compareTo(Box o) {
            
            return o.n - this.n;
        }
        @Override
        public String toString() {
            return "Box [n=" + n + ", h=" + h + ", w=" + w + "]";
        }
        
        
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    
        StringTokenizer st ;
        // 밑면이 좁은 상자 위에 밑면이 더 넓은 상자 x
        // 무게가 무거운 상자는 무게가 가벼운 상자 위에 x
        
        List<Box> list = new ArrayList<>();
        for(int i =0 ;i< N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Box(n,h,w,i+1));
            
        }
        Collections.sort(list);
        
        int [] dp = new int[N];
        int [] cnt = new int[N];
        String [] route = new String[N];
    
        for(int i =0 ;i< list.size();i++) {
            dp[i] = list.get(i).h;
            cnt[i] = 1;
            route[i] = ""+ list.get(i).num;
            for(int j = 0 ;j< i; j++) {
                if(list.get(i).w < list.get(j).w){
                    if(dp[i]  < dp[j] + list.get(i).h) {
                        dp[i] = list.get(i).h + dp[j];
                        cnt[i] = cnt[j] +1;
                        route[i] = route[j] +" " +list.get(i).num;
                    }
                    
                }
            }
        }
        int max = 0;
        String result = null;
        for(int i =0;i<list.size();i++) {
            if(max < dp[i]) {
                max = dp[i];
                result = route[i]; 
            }
        }
        

        String []t = result.trim().split(" ");
        System.out.println(t.length);
        for(int i = t.length-1; i>-1 ;i--) {
            System.out.println(t[i]);
        }

    }
}