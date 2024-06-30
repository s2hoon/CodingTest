import java.util.*;
import java.io.*;
public class Main5430 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T>0){
            String [] cmd = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String [] arr = br.readLine().split("\\[|\\]|,"); // 1부터 시작
            Deque<Integer> deque = new LinkedList<>();
            for(int i = 1; i< arr.length;i++){
                deque.add(Integer.parseInt(arr[i]));
            }
            boolean isR = true;
            boolean isE = false;
            for(int i =0 ;i< cmd.length;i++){
                if(cmd[i].equals("R")){
                    if(isR==true){
                        isR = false;
                    }else{
                        isR = true;
                    }
                
                }
                if(cmd[i].equals("D")){
                    if(deque.size()==0){
                        System.out.println("error");
                        isE = true;
                        break;
                    }
                    if(isR==true){
                        deque.removeFirst();
                    }
                    if(isR ==false){
                        deque.removeLast();
                    }
                }
            }
            List<Integer> list = new LinkedList<>();
            if(isR==true){
                while(!deque.isEmpty()){
                    list.add(deque.pollFirst());
                }
            }
            if(isR==false){
                while(!deque.isEmpty()){
                    list.add(deque.pollLast());
                }
            }
 
           
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()){
                int s = iterator.next();
                sb.append(s);
                sb.append(",");
            }
            if(sb.length()!=1){
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append("]");
            if(isE==false){
                System.out.println(sb.toString());
            }
            


            T-=1;
        }



        
    }
}
