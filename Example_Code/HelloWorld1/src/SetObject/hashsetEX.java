package SetObject;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class hashsetEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		useEXHashSet();
		useEXArrayList();
		
		

	}
	public static void useEXHashSet(){
		System.out.println("_____Use HashSet Example____ ");
		// 2 value same . it only use 1 memory
		Set<Integer> hs = new HashSet<Integer>();
		hs.add(new Integer("1"));
		hs.add(new Integer("2"));
		hs.add(new Integer("3"));
		hs.add(new Integer("1"));
		
		
		
		Object obj = Collections.min(hs);
		Object obj1 = Collections.max(hs);
		System.out.println(hs);
		System.out.println("number min in hashset is : "+obj+"  _____ number max in hashset:"+obj1);
	};
	public static void useEXArrayList(){
		System.out.println("_____Use ArrayList Example ____");
		// 2 value same . it use every value every memory
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(new Integer ("1"));
		arrayList.add(new Integer ("1"));
		arrayList.add(new Integer ("3"));
		
		
		System.out.println(" all value in arraylist:" +arrayList);
		System.out.println(" value in position 2 is :"+arrayList.get(2));
		
		ArrayList< String> array = new ArrayList<String>();
		array.add("Phan tu thu 1");
		array.add("Phan tu thu 2");
		array.add("Phan tu thu 3");
		array.add("Phan tu thu 4");
		
		System.out.println(array);
		System.out.println(array.get(2));
	};
	

}
