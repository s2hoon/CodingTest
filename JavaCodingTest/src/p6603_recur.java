import java.io.*;
import java.util.*;

public class p6603_recur {

    static int[] sets;
    static List<Integer> lotto = new ArrayList<>();

    public static void recursive( int cnt, int index){
        // 내가 원하는 상황
        if(cnt == 0){
            for(int num : lotto){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        // 더이상 진행 불가
        if(index == sets.length){
            return;
        }

        // 추가
        lotto.add(sets[index]);
        // 내가 원하는 상황 검사
        recursive(cnt-1, index+1);
        // 제거
        lotto.remove(lotto.size()-1);

        // 추가
        // 내가 원하는 상황 검사
        recursive(cnt,index+1);
        // 제거

     



    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        if (K == 0){
            break;
        }
        sets = new int[K];
        for(int i = 0 ; i< K; i++){
            sets[i] = Integer.parseInt(st.nextToken());
        }
        recursive(6, 0);
        System.out.println();
       

    }


    }
    
}
