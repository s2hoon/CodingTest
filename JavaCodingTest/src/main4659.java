import java.util.*;
import java.io.*;
public class main4659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s ;
        while(!(s = br.readLine()).equals("end")){
            boolean flag = true;
            if( !s.contains("a")&&!s.contains("e")&&!s.contains("i")&&!s.contains("o")&&!s.contains("u") ){
                flag =false;
            }
            for(int i= 0;i <= s.length()-3; i++){
                int cnt = 0;
                for(int j=i; j<i+3; j++){
                    if( s.charAt(j)=='a' || s.charAt(j)=='e'|| s.charAt(j)=='i'|| s.charAt(j)=='o'|| s.charAt(j)=='u') {
                        cnt+=1;
                    }
                }
           
                if(cnt >=3){
                   flag =false;
                   break; 
                }

            }
            for(int i= 0;i<= s.length()-3; i++){
                int cnt =0;
                for(int j=i; j<i+3; j++){

                    if( s.charAt(j)!='a' && s.charAt(j)!='e'&& s.charAt(j)!='i'&& s.charAt(j)!='o'&& s.charAt(j)!='u') {
                        cnt+=1;
                    }
                }
                if(cnt >=3){
                   flag =false;
                   break; 
                }
            }

            for(int i= 0;i<= s.length()-2; i++){
                int cnt = 0;
                char t = s.charAt(i);
                for(int j=i; j<i+2; j++){
                    if( s.charAt(j)==t) {
                        cnt+=1;
                    }
                    
                }
                if(cnt >=2 && t!='o' && t!='e'){
                    flag =false;
                    break;
                }
                

            }

            if(flag==false){
                System.out.println("<"+s+"> "+ "is not acceptable.");
                continue;
            }else{
                System.out.println("<"+s+"> "+"is acceptable.");
                continue;
            }

        }
    }
}


