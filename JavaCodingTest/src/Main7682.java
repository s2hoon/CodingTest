import java.util.*;
import java.io.*;
public class Main7682 {

    static StringBuilder sb;
    static Set<String> sets = new HashSet<>();
  

        public static int End(String[][] graph) { // 게임이 끝났는지 확인해주는 메서드.
            for (int i = 0; i < 3; i++) {
                // 가로 확인
                if (graph[i][0].equals(graph[i][1]) && graph[i][1].equals(graph[i][2])) {
                    if (graph[i][0].equals('X') || graph[i][0].equals('O')) {
                        return 1; // i 번째 가로가 모두 X 또는 O 라면
                    }
                }
                // 세로 확인
                if (graph[0][i].equals(graph[1][i]) && graph[1][i].equals(graph[2][i])) {
                    if (graph[0][i].equals('X') || graph[0][i].equals('O')) {
                        return 1; // i 번째 세로가 모두 X 또는 O 라면
                    }
                }
            }
            
            // 왼쪽 위에서 오른쪽 아래로 가는 대각선 확인
            if (graph[0][0].equals(graph[1][1]) && graph[1][1].equals(graph[2][2])) {
                if (graph[0][0].equals('X') || graph[0][0].equals('O')) {
                    return 1; // 왼쪽 위에서 오른쪽 아래로 가는 대각선이 모두 X 또는 O 라면
                }
            }
            
            // 오른쪽 위에서 왼쪽 아래로 가는 대각선 확인
            if (graph[0][2].equals(graph[1][1]) && graph[1][1].equals(graph[2][0])) {
                if (graph[0][2].equals('X') || graph[0][2].equals('O')) {
                    return 1; // 오른쪽 위에서 왼쪽 아래로 가는 대각선이 모두 X 또는 O 라면
                }
            }
            
            return 0; // 게임이 끝났지 않았다면 0 을 반환한다.

        }

    public static void recursive(int x, int y, String[][] graph, int turn){


        if((x==2 && y==3) || (End(graph)==1)){
            sb = new StringBuilder();
            for(int i =0 ;i< 3 ;i++){
                for(int j =0; j<3; j++){
                    sb.append(graph[i][j]);
                }
            }
            sets.add(sb.toString());
            return;
        }

     
        if(x==0 && y==0){
            recursive(x,y+1,graph, (turn+1)%2);
            String[][] temp_graph = getTemp_graph(graph);
            if(turn==0){
            temp_graph[x][y] = "O";
            recursive(x,y+1,temp_graph,(turn+1)%2);
            }else{

            temp_graph[x][y] = "X";
            recursive(x,y+1,temp_graph);
        }
        if(x==0 && y==1){
            recursive(x,y+1,graph);
            String[][] temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "O";
            recursive(x,y+1,temp_graph);
            temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "X";
            recursive(x,y+1,temp_graph);
        }
        if(x==0 && y==2){
            recursive(x+1,y-2,graph);
            String[][] temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "O";
            recursive(x+1,y-2,temp_graph);
            temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "X";
            recursive(x+1,y-2,temp_graph);
        }
        if(x==1 && y==0){
            recursive(x,y+1,graph);
            String[][] temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "O";
            recursive(x,y+1,temp_graph);
            temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "X";
            recursive(x,y+1,temp_graph);
        }
        if(x==1 && y==1){
            recursive(x,y+1,graph);
            String[][] temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "O";
            recursive(x,y+1,temp_graph);
            temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "X";
            recursive(x,y+1,temp_graph);
        }
        if(x==1 && y==2){
            recursive(x+1,y-2,graph);
            String[][] temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "O";
            recursive(x+1,y-2,temp_graph);
            temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "X";
            recursive(x+1,y-2,temp_graph);
        }
        if(x==2 && y==0){
            recursive(x,y+1,graph);
            String[][] temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "O";
            recursive(x,y+1,temp_graph);
            temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "X";
            recursive(x,y+1,temp_graph);
        }
        if(x==2 && y==1){
            recursive(x,y+1,graph);
            String[][] temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "O";
            recursive(x,y+1,temp_graph);
            temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "X";
            recursive(x,y+1,temp_graph);
        }
        if(x==2 && y==2){
            recursive(x,y+1,graph);
            String[][] temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "O";
            recursive(x,y+1,temp_graph);
            temp_graph = getTemp_graph(graph);
            temp_graph[x][y] = "X";
            recursive(x,y+1,temp_graph);
        }



    }


    private static String[][] getTemp_graph(String[][] graph) {
        String [][] temp_graph = new String[9][9];
        for(int i = 0 ;i<3;i++){
            for(int j =0 ;j<3; j++){
                temp_graph[i][j] = graph[i][j];
            }
        }
        return temp_graph;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] graph = new String[3][3];
        for(int i = 0;i<3;i++){
            Arrays.fill(graph[i],".");
        }
        recursive(0,0,graph);

        String t;
        while( !(t = br.readLine()).equals("end")){
            if(sets.contains(t)){
                System.out.println("valid");
            }else{
                System.out.println("invalid");
            }

        }
        


    }
}
