import java.util.*;
import java.io.*;

public class p9663 {
    
    static int N ;
    static boolean [] check_row;
    static boolean [] check_col;
    static boolean [] check_de;
    static boolean [] check_de2;
    static int answer= 0;


    public static void BackTrack(int row) {
        if (row == N) {
            answer += 1;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!check_row[row] && !check_col[col] && !check_de[row + col] && !check_de2[row - col + N - 1]) {
                check_row[row] = true;
                check_col[col] = true;
                check_de[row + col] = true;
                check_de2[row - col + N - 1] = true;

                BackTrack(row + 1);

                check_row[row] = false;
                check_col[col] = false;
                check_de[row + col] = false;
                check_de2[row - col + N - 1] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check_col = new boolean[N];
        check_row = new boolean[N];
        check_de = new boolean[2*N];
        check_de2 = new boolean[2*N];
        BackTrack(0);
        System.out.println(answer);
    }
}
