package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "C:/Users/000QPC744/chromedriver_win32/chromedriver.exe");
     WebDriver driver = new ChromeDriver();
    
     
     //Alerts
  /*   driver.get("http://demo.guru99.com/test/delete_customer.php");
    driver.findElement(By.name("cusid")).sendKeys("432145");
    driver.findElement(By.name("submit")).click();
    String text= driver.switchTo().alert().getText();
    System.out.println(text);
    //Thread.sleep(3000);
    driver.switchTo().alert().accept();
    */
     
     //Windows
     driver.manage().window().maximize();
     driver.get("http://demo.guru99.com/popup.php");
     driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
     String mainWindow= driver.getWindowHandle();
     Set<String> ch= driver.getWindowHandles();
     Iterator<String> itr= ch.iterator();
     while(itr.hasNext())
     {
    	 
    	 String childWindow= itr.next();
    	 if(!mainWindow.equalsIgnoreCase(childWindow))
    	 {
    		 driver.switchTo().window(childWindow);
    		 driver.findElement(By.name("emailid")).sendKeys("sudh@gmail.com");
    		 driver.findElement(By.name("btnLogin")).click();
    		 //driver.close();
    	 }
     }
    // driver.switchTo().window(mainWindow);
     
     String title= driver.findElement(By.xpath("//td[contains(text(),'mngr')]")).getText();
     System.out.println(title);
    
    
    
    
    
	}

}
