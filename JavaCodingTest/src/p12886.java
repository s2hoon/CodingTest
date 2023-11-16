
import java.util.*;
import java.io.*;



public class p12886 {

    static int A;
    static int B;
    static int C;
    static int answer =0;
    static Set<int[]> set=new HashSet<>(); 

    public static void BFS(int a, int b , int c){


        if ((a+b+c)%3!=0){

            return;
        }
        set.add(new int[]{a,b,c});
        Queue<int[]> queue = new LinkedList<>();
        int[] start = new int[]{a,b,c};
        Arrays.sort(start);
        queue.add(start);
        while(queue.peek()!=null){
            int[] p =queue.poll();
            Arrays.sort(p);

 

            if (p[0]==p[1] && p[1]==p[2]){
                answer = 1;
                return;
            }
            if (set.contains(new int[]{p[0],p[1],p[2]})){
                return;
            }
         
            // a 랑 b
            if(p[0] !=p[1] && !set.contains(new int[]{p[0]+p[0],p[1]-p[0],p[2]})){
                set.add(new int[]{p[0]+p[0],p[1]-p[0],p[2]});
                queue.add(new int[]{p[0]+p[0] ,p[1]-p[0],p[2]});
            }
        
            // b 랑 c
             if(p[1] !=p[2] && !set.contains(new int[]{p[0],p[1]+p[1],p[2]-p[1]})){
                set.add(new int[]{p[0],p[1]+p[1],p[2]-p[1]});
                queue.add(new int[]{p[0] ,p[1]+p[1],p[2]-p[1]});
            }

            // a 랑 c
             if(p[0] !=p[2] && !set.contains(new int[]{p[0]+p[0],p[1],p[2]-p[0]})){
                set.add(new int[]{p[0]+p[0],p[1],p[2]-p[0]});
                queue.add(new int[]{p[0]+p[0] ,p[1],p[2]-p[0]});
            }

        }


    }




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


     

       BFS(A,B,C);
        System.out.println(answer);





    }


    
}