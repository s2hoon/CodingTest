
import java.io.*;
import java.util.*;

public class Main {
    
    static int [][] graph;
    static List<int[]> points;
    static boolean[][] check_row;
    static boolean[][] check_col;
    static boolean[][] check_square;
    static int answer = 0;

    public static boolean BackTrack(){
        if(points.size() == 0){
           
            return true;
        }
        // 불가능한 경우
    
      
        for(int i=1; i<10; i++ ){
            // 준비
            int[] p =points.get(0);

        
            // 체크 
            if(check_row[p[0]][i] == false && check_col[p[1]][i]==false && check_square[(p[0]/3)*3+p[1]/3][i] == false && graph[p[0]][p[1]]==0){
                points.remove(0);
                check_row[p[0]][i] =true; 
                check_col[p[1]][i]= true; 
                check_square[(p[0]/3)*3+p[1]/3][i] =true;
                graph[p[0]][p[1]] = i;
                if(BackTrack()){
                    return true;
                }
                graph[p[0]][p[1]] = 0;
                points.add(0,p);
                check_row[p[0]][i] =false; 
                check_col[p[1]][i]= false; 
                check_square[(p[0]/3)*3+p[1]/3][i] =false;
                
            }
         
        
        }
        return false;
        

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[9][9];
        points = new ArrayList<>();
        check_row = new boolean[9][10];
        check_col = new boolean[9][10];
        check_square = new boolean[9][10];
        for(int i =0 ; i< 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<9; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 0){   
                    points.add(new int[]{i,j});
                }else{
                    check_row[i][graph[i][j]] = true;
                    check_col[j][graph[i][j]]  =true;
                    check_square[(i/3)*3+(j/3)][graph[i][j]] = true;
                }
            }
        }
  
     
        BackTrack();
        for(int[]   t : graph){
            for(int k : t){
                System.out.print(k +" ");
            }
            System.out.println();
        }

    }
}


// 0 0 0 0 0 0 0 0 9
// 0 0 0 0 0 0 0 0 8
// 0 0 0 0 0 0 0 0 7
// 0 0 0 0 0 0 0 0 6
// 0 0 0 0 0 0 0 0 5
// 0 0 0 0 0 0 0 0 4
// 0 0 0 0 0 0 0 0 3
// 0 0 0 0 0 0 0 0 2
// 0 0 0 0 0 0 0 0 1