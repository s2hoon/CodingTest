
import java.util.*;
import java.io.*;


public class Main2252 {
    
    static int N;
    static int M;
    static List<Integer>[] students;
    static int[] count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N+1];
        students = new ArrayList[N+1];
        for(int i = 1 ;i<N+1; i++){
            students[i] = new ArrayList<>();
        }
        for(int i =0 ;i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            students[A].add(B);
            count[B]+=1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<N+1; i++){
            if(count[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v+" ");
            for(int i =0;i< students[v].size();i++){
                int t = students[v].get(i);
                count[t]-=1;
                if(count[t]==0){
                    queue.add(t);
                }

            }
            
        }




    }

}
