package selenium;

import java.util.*;

public class LoopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		SortedSet<String> ts= new TreeSet<String>();
		List<String> pay_id_List = new ArrayList<String>();
		List<String> Error_list = new ArrayList<String>();
		String pay_id;
		ts.add("5684");
		ts.add("5685");
		ts.add("5685");
		ts.add("5686");
		ts.add("5686");
		pay_id_List.add("5684");
		pay_id_List.add("5685");
		pay_id_List.add("5685");
		pay_id_List.add("5686");
		pay_id_List.add("5686");
		Error_list.add("E31");
		Error_list.add("E71");
		Error_list.add("IC71");
		Error_list.add("E71");
		Error_list.add("IC31");
		int idx=0;
		Iterator<String> tsItr= ts.iterator();
		Iterator<String> ErItr= Error_list.iterator();
		while(tsItr.hasNext())
		{
			pay_id=tsItr.next();
			System.out.println("Inside 1st while loop:"+pay_id);
			//if(idx<pay_id_List.size())
			//{
				System.out.println("Inside 1st If loop:"+pay_id+"Index:"+idx);
				while(pay_id_List.get(idx)==pay_id)
				{
					System.out.println("Inside while payidList:"+pay_id_List.get(idx));
					System.out.println(ErItr.next());
					idx++;
					if(idx>=pay_id_List.size())
					{
						break;
					}
					System.out.println("End of Inner while loop");
					
				}
		   //}
				System.out.println("End of 1stwhile loop");
		}
		
		
	}

}
