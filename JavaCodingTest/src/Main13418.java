
import java.util.*;
import java.io.*;
public class Main13418 {


    static int [] parent;
    static int find_root(int x){
        if(parent[x] ==x){
            return x;
        }
        parent[x] = find_root(parent[x]);
        return parent[x];
    }

    static void union(int a, int b){
        int x1 = find_root(a);
        int x2 = find_root(b);
        if(x1 == x2){
            return;
        }
        if(x1 > x2){
            parent[x1] =x2;
        }else{
            parent[x2] =x1;
        }

    }

    static class Edge1 implements Comparable<Edge1>{
        int from;
        int to;
        int w;
        public Edge1(int from , int to , int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Edge1 o) {
            return this.w - o.w;
        }
        
    }

    static class Edge2 implements Comparable<Edge2>{
        int from;
        int to;
        int w;
        public Edge2(int from , int to , int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Edge2 o) {
            return o.w - this.w;
        }
        
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Edge1> list1 = new ArrayList<>();
        List<Edge2> list2 = new ArrayList<>();
        for(int i =0 ;i< M+1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list1.add(new Edge1(from , to ,w));
            list2.add(new Edge2(from, to, w));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        parent = new int[N+1];
        for(int i =0 ;i<N+1; i++){
            parent[i] = i;
        }
        int cnt = 0;
        for(Edge1 e : list1){
            if(find_root(e.from) != find_root(e.to)){
                union(e.from, e.to);
                if(e.w==0){
                    cnt +=1;
                }
            }
        }
        parent = new int[N+1];
        for(int i =0 ;i<N+1; i++){
            parent[i] = i;
        }
        int cnt2 = 0;
        for(Edge2 e : list2){
            if(find_root(e.from) != find_root(e.to)){
                union(e.from, e.to);
                if(e.w==0){
                    cnt2 +=1;
                }
            }
        }

        cnt2 = cnt2 * cnt2;
        cnt = cnt * cnt;
        System.out.println(Math.abs(cnt2-cnt));
    }

}
