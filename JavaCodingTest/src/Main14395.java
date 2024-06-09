import java.util.*;
import java.io.*;

public class Main14395 {
    
    static HashSet<Long> set = new HashSet<>();
    static long s;
    static long t;
    
    static boolean flag =false;
    static class Node{
        long num;
        String operator;
        public Node(long num , String operator){
            this.num = num;
            this.operator = operator;
        }


    }
    public static void BFS(long start){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start,""));
        set.add(start);
        while(!queue.isEmpty()){
            Node n = queue.poll();
            
            if(n.num==t){
                System.out.println(n.operator);
                flag =true;
                continue;
            }
            
            long t = n.num * n.num;
            if(!set.contains(t)){
                set.add(t);
                queue.add(new Node(t,n.operator+"*"));
            }

            t = n.num + n.num;
            if(!set.contains(t)){
                set.add(t);
                queue.add(new Node(t,n.operator+"+"));
            }
            t = n.num - n.num;
            if(!set.contains(t)){
                set.add(t);
                queue.add(new Node(t,n.operator+"-"));
            }
            if(n.num!=0){
                t = n.num / n.num;
                if(!set.contains(t)){
                    set.add(t);
                    queue.add(new Node(t,n.operator+"/"));
                }
            }   


        }


    }
    
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Long.parseLong(st.nextToken());
        t = Long.parseLong(st.nextToken());
        if(s==t){
            System.out.println(0);
            return;
        }
       
        BFS(s);
        if(flag==false){
            System.out.println(-1);
        }

    }
}
