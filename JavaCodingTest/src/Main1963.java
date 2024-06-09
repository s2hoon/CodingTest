import java.io.*;
import java.util.*;
public class Main1963 {


    public static boolean sosu(String num){
        int x = Integer.parseInt(num);
        boolean flag = true;
        for(int i =2 ;i< Math.sqrt(x)+1;i++){
            if(x%i==0){
                flag =false;
            }
        }
        return flag;
    }
    static boolean [] visited;
    static boolean flag;
    static int result;
    public static void BFS(String num, int endNum){
        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[] {num,"0"});
        int n = Integer.parseInt(num);
        visited[n] = true;
        while(!queue.isEmpty()){
     
            String[] t = queue.poll();
    
            if(!sosu(t[0])){
                continue;
            }
            if(Integer.parseInt(t[0])<1000){
                continue;
            }
            if(Integer.parseInt(t[0])==endNum){
                flag =true;
                result = t[1].length()-1;
                return;
            }
            for(int i = 1;i<= 9;i++){
                int k = Integer.parseInt(i+t[0].substring(1,4));
                if(visited[k]==false){
                    queue.add(new String[] {String.valueOf(k),t[1]+1});
                    visited[k] = true;
                }
            }
            for(int i =0 ;i<=9;i++){
                int k;
                k= Integer.parseInt(t[0].substring(0, 1)+i+t[0].substring(2, 4));
                if(visited[k]==false){
                    queue.add(new String[] {String.valueOf(k),t[1]+1});
                    visited[k] = true;
                }
                k= Integer.parseInt(t[0].substring(0, 2)+i+t[0].substring(3, 4));
                if(visited[k]==false){
                    queue.add(new String[] {String.valueOf(k),t[1]+1});
                    visited[k] =true;
                }
                k= Integer.parseInt(t[0].substring(0, 3)+i);
                if(visited[k]==false){
                    queue.add(new String[] {String.valueOf(k),t[1]+1});
                    visited[k] = true;
                }

            }
        }
        

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        for(int test_case =0 ;test_case <T; test_case++){
            visited = new boolean[10000];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!sosu(String.valueOf(a))||!sosu(String.valueOf(b))){
                System.out.println("Impossible");
                continue;
            }
            flag =false;
            BFS(String.valueOf(a),b);
            if(flag==true){
                System.out.println(result);
            }else{
                System.out.println("Impossible");
            }
        }




    }

}
