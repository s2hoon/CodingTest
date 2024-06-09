
import java.util.*;
import java.io.*;
public class Main23289 {
    
    static int R;
    static int C;
    static int K;
    static int [][] graph;
    static int [][][] wall;
    static boolean [][] visited;
    static int W;
    static List<Machine> onponggi = new ArrayList<>();
    static List<Point> zosapilyo = new ArrayList<>();
    static int [][] dx = {{},{-1,0,1},{-1,0,1},{-1,-1,-1},{1,1,1}};
    static int [][] dy = {{},{1,1,1},{-1,-1,-1},{-1,0,1},{-1,0,1}};
    static int []dx2 = {0,1,0,-1};
    static int []dy2= {1,0,-1,0};
    
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Machine{
        int x;
        int y;
        int d;
        int dist;
        public Machine(int x, int y, int d, int dist) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.dist = dist;
        }
        @Override
        public String toString() {
            return "Machine [x=" + x + ", y=" + y + ", d=" + d + ", dist=" + dist + "]";
        }
        
    }
    
    
    public static void down() {
        
        for(int i =0 ;i< C; i++) {
            if(graph[0][i]>=1) {
                graph[0][i]-=1;
            }
            if(graph[R-1][i]>=1) {
                graph[R-1][i]-=1;
            }
        }
        for(int i =0;i<R;i++){
            if(graph[i][0] >=1){
                graph[i][0]-=1;
            }
            if(graph[i][C-1]>=1){
                graph[i][C-1]-=1;
            }
        }
        
        
    }
    
    
    public static void wind() {
        for(Machine m : onponggi) {
            visited = new boolean[R][C];
            Queue<Machine> queue = new LinkedList<>();
            queue.add(new Machine(m.x+dx[m.d][1] , m.y+dy[m.d][1], m.d, m.dist));
            graph[m.x+dx[m.d][1]][m.y+dy[m.d][1]] = m.dist;
            visited[m.x+dx[m.d][1]][m.y+dy[m.d][1]] = true;
            while(!queue.isEmpty()) {
                Machine t = queue.poll();
                int x = t.x;
                int y = t.y;
                int d = t.d;
                int dist = t.dist;
                if(dist ==0) {
                    continue;
                }
                for(int i =0 ;i<3; i++) {
                    int nx = x + dx[d][i];
                    int ny = y + dy[d][i];
                    if(nx >= R || nx <0 || ny >= C || ny <0) {
                        continue;
                    }
                    
                    if(wall[nx][ny][d]==1) {
                        continue;
                    }
                    if(visited[nx][ny]==false) {
                        visited[nx][ny] =true;
                        graph[nx][ny] += dist-1;
                        queue.add(new Machine(nx,ny,d,dist-1));
                    }
                    
                
                }
                
            }

        }
    }
    
    public static void jozul() {
        
        int[][] temp_graph = new int[R][C];
        for(int i =0 ;i<R; i++) {
            for(int j =0 ;j<C;j++) {
                temp_graph[i][j] = graph[i][j];
            }
        }
        
        for(int i =0 ;i< R;i++){
            for(int j =0 ;j<C; j++) {
                int  p = 0;
                for(int d =0 ;d< 4; d++) {
                    int nx = i+ dx2[d];
                    int ny = j+ dy2[d];
                    if(nx>= R||nx<0 || ny>=C|| ny<0) {
                        continue;
                    }
                    if(graph[nx][ny] < graph[i][j] ) {
                        p +=(graph[i][j]-graph[nx][ny])/4;
                        temp_graph[nx][ny] += (graph[i][j]-graph[nx][ny])/4;
                    }
                    
                }
                temp_graph[i][j] -= p;
                
            }
        }
        for(int i =0 ;i<R; i++) {
            for(int j =0 ;j<C;j++) {
                graph[i][j] = temp_graph[i][j];
            }
        }

    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[R][C];
        wall = new int[R][C][5];
        for(int i= 0;i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0 ;j<C;j++) {
                int t = Integer.parseInt(st.nextToken());
                if(t == 1 ||t==2 ||t==3||t ==4) {
                    onponggi.add(new Machine(i,j,t,5));
                }
                if(t ==5) {
                    zosapilyo.add(new Point(i,j));
                }
            }
        }
        W = Integer.parseInt(br.readLine());
        for(int i =0;i<W; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken());
            if(t==0) {
                wall[x-1][y][3] = 1;
                wall[x][y][4] =1;
            }
            if(t==1) {
                wall[x][y][2] = 1;
                wall[x][y+1][1] = 1;
            }
            
        }
        
        int chocolate = 0;
        while(chocolate<=100) {
            wind();
            jozul();
            down();
            chocolate+=1;
            boolean flag = true;
            for(Point p : zosapilyo) {
                if(graph[p.x][p.y]<K) {
                    flag = false;
                }
            }
            if(flag ==true) {
                break;
            }
        }
        System.out.println(Arrays.deepToString(graph));
        System.out.println(chocolate);
    
        
    }
}
