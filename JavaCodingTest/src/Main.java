import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
 


    public static void main(String[] args) throws Exception {

            int [] numbers = {1,2,3,4,5};

            List<Integer> l = new ArrayList<>(Arrays.stream(numbers).boxed().collect(Collectors.toList()));

            System.out.println(Collections.max(l));

            
        }
      



    


}
