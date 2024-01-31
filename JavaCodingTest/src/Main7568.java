import java.util.*;
import java.io.*;
public class Main7568 {

	
	static int N;
	static List<Person> peoples = new ArrayList<>();
	static class Person implements Comparable<Person>{
		public int weight;
		public int height;
		public int count;
		
		Person(int weight, int height){
			this.weight = weight;
			this.height = height;
			this.count = 0;
		}

		@Override
		public int compareTo(Person o) {
			if(this.weight < o.weight) {
				if(this.height < o.height) {
					return 1;
				}
				return 0;
            }
            return 0;
			
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i =0; i< N ;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			peoples.add(new Person(a,b));
			
		}
	
		
		for(int i =0; i< peoples.size(); i++) {
			for(int j =0; j< peoples.size(); j++) {
				if(peoples.get(i).compareTo(peoples.get(j))==1) {
					peoples.get(i).count +=1;
				}
		
			}
		
		}
		for(Person p : peoples) {
			System.out.print(p.count+1+" ");
		}
		
		
		
	}
}

