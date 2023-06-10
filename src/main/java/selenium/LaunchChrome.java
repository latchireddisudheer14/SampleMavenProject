package selenium;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {
	
	 static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	    public static void insert(ListNode l1,int va)
	    {
	    	ListNode newNode = new ListNode(va);
	    	if(l1.next==null)
	    		l1.next=newNode;
	    	else {
	    		ListNode currNode= l1;
	    		while(currNode.next!=null)
	    		{
	    			currNode=currNode.next;
	    		}
	    		currNode.next=newNode;
	    	}
	    		
	    	
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\000QPC744\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		String expectedTitle = "Welcome: Mercury";
		String actualTitle="";
		actualTitle= driver.getTitle();
		if(expectedTitle.contentEquals(actualTitle))
		{
			System.out.println("passed");
		}
		else {
			System.out.println("failed");
		}*/
		
		
	    ListNode ll1= new ListNode(0);
	    insert(ll1, 2);
	    insert(ll1,3);
	    insert(ll1,5);
	    System.out.println(ll1.next);
	    
	    while(ll1!=null)
	    {
	    	System.out.println(ll1.val);
	    	ll1=ll1.next;
	    	
	    }       
		

	}

}
