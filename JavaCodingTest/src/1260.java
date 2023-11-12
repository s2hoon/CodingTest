import java.util.*;
import java.io.*;


public class 1260 {

    static int N ;
    static int M ;
    static boolean[] visited2;
    public static void DFS(int start, List<List<Integer>> graph){
        
        if(!visited2[start]){
            visited2[start] = true;
            System.out.print(start+" ");
            for(Integer g : graph.get(start)){
                if(visited2[g] == false){
                    DFS(g, graph);
                }

            }
        }
     

       
    }

    public static void BFS(int start, List<List<Integer>> graph){
        boolean[] visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            visited[i] = false;
        }
    
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
  
        while(queue.peek()!=null){
            int node =queue.poll();
            System.out.print(node+" ");
            for(Integer t : graph.get(node)){
                if(visited[t]==false){
                    visited[t] = true;
                    queue.add(t);
                }

            }
            
        }
  

    }

  
    public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
    
          
            List<List<Integer>> graph = new ArrayList<>();
            for(int i=0; i< N+1; i++){
                graph.add(new ArrayList<>());
            }

            for( int i =0; i< M ; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for(int i =0 ;i< N+1; i++){
                Collections.sort(graph.get(i));
            }
          
            visited2 = new boolean[N+1];
              for(int i = 0; i < N+1; i++) {
                visited2[i] = false;
            }
            DFS(V,graph);
            System.out.println();
            BFS(V,graph);
           

            
        }
      



}
