import java.util.*;
import java.io.*;
public class Main1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0 ;i<N; i++){
            int t = Integer.parseInt(br.readLine());
            pq.add(t);
        }
        if(N==1){
            System.out.println(0);
            return;
        }

        int sum =0;
        while(!pq.isEmpty()){
            int t1 = pq.poll();
            int t2 = pq.poll();
            sum += t1;
            sum += t2;
            pq.add(t1+t2);
            if(pq.size()==1){
                break;
            }
        }
        System.out.println(sum);



    }
}
