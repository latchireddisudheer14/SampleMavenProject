package selenium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class ColectionsDemo {
	
	/*public static void colArray(Object[] str)
	{
		for(Object i : str)
	      {
			String j= (String)i;
	    	 
			System.out.println("Str1"+i);
			System.out.println("Str2"+j);
	      }
		
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      /*ArrayList<String> al = new ArrayList<String>();
      al.add("Hello");
      al.add(1,"Sudheer");
      System.out.println(al);
      for(String i : al)
      {
    	  System.out.println(i);
      }
      
      colArray( al.toArray());*/
		//LinkedList<String> ll = new LinkedList<String>();
		TreeSet<String> ll= new TreeSet<String>();
		ll.add("Hello");
		ll.add("linkedList");
		ll.remove("linkedList");
		ll.add("TreeSet");
		System.out.println(ll);
		
	}

}
