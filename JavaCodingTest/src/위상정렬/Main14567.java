package 위상정렬;
import java.util.*;
import java.io.*;
public class Main14567 {

    public static class Node{
        int rank;
        int value;
        public Node(int rank, int value){
            this.rank = rank;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] edges = new ArrayList[N+1];
        for(int i =0;i< N+1; i++){
            edges[i] = new ArrayList<>();
        }
        int[] count = new int[N+1];
        for(int i =0 ;i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            count[to]+=1;
        }
        
        Queue<Node> queue = new LinkedList<>();
        for(int i = 1;i<N+1;i++){
            if(count[i]==0){
                queue.add(new Node(1,i));
            }
        }
        int [] result = new int[N+1];
        while(!queue.isEmpty()){
            Node n  = queue.poll();
            result[n.value] = n.rank;
  
            for(int i =0 ;i < edges[n.value].size() ;i++){
                count[edges[n.value].get(i)]-=1;
                if(count[edges[n.value].get(i)]==0){
                    queue.add(new Node(n.rank+1,edges[n.value].get(i)));
                }
            }
        }

        for(int i =1 ;i< N+1; i++){
            System.out.print(result[i]+" ");
        }
        

    
        
    }
}
