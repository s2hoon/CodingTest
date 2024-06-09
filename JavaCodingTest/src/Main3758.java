import java.io.*;
import java.util.*;
public class Main3758 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int test_case = 0 ;test_case <T; test_case++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t= Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int [][] point = new int[n+1][k+1];
            int [] time = new int[n+1];
            int [] cnt = new int[n+1];
            for(int i =0 ;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                point[id][j] = Math.max(point[id][j],s);
                time[id] = Math.max(time[id],i);
                cnt[id] +=1;
            }
            List<int[]> list= new ArrayList<>();
            for(int i =1 ;i<n+1; i++){
                int p = 0;
                for(int j = 1;j<k+1;j++){
                    p += point[i][j];
                }
                list.add(new int[]{p, cnt[i],time[i],i});
            }
            Collections.sort(list, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1 , int[] o2){
                    if(o1[0]!=o2[0]){
                        return o2[0]-o1[0];
                    }
                    if(o1[1]!=o2[1]){
                        return o1[1]-o2[1];
                    }
                    if(o1[2]!=o2[2]){
                        return o1[2]-o2[2];
                    }
                    return 0;
                }
            });
            for(int i =0 ;i< list.size();i++){
                if(list.get(i)[3]==t){
                    System.out.println(i+1);
                    break;
                }
            }

        }
    
    }

}
