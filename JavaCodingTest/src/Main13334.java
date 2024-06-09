import java.util.*;
import java.io.*;
public class Main13334 {
    


    static class Node implements Comparable<Node>{
        int start;
        int end;
        public Node(int start, int end){
            this.start =start;
            this.end = end;
        }
        @Override
        public int compareTo(Node o) {
            if(this.end!=o.end){
                return o.end -this.end;
            }else if(this.start!=o.start){
                return o.start - this.start;
            }
            return 0;
        }
        @Override
        public String toString() {
            return "Node [start=" + start + ", end=" + end + "]";
        }
        

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Node> lists = new ArrayList<>();
        for(int i = 0;i< n;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start > end){
                int temp= start;
                start = end;
                end = temp;
            }
            lists.add(new Node(start, end));
        }
        int d = Integer.parseInt(br.readLine());
        Collections.sort(lists);
        System.out.println(lists.toString());
        int result = 0;
        for(int i = 0; i< lists.size();i++){
            int cnt = 0;
            Node node = lists.get(i);
            int tempStart = node.start;
            while(true){
                Node k = lists.get(i);
                if(tempStart <= k.start && tempStart + d >= k.end){
                    cnt +=1;    
                    i++;
                    if( i==lists.size()){
                        break;
                    }
                }else{
                    break;
                }
            }
            result = Math.max(result, cnt);

        }
        System.out.println(result);
    }
    
    
}
