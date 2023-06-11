package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RebuildAndRelease {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/000QPC744/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ftm-control-center-ipc-keybank-st.ipc-keybank-nonprod-roks-b621399b0c4e883a72804711a921fd8d-i000.us-south.containers.appdomain.cloud/fxh/login.jsp#home");
		Thread.sleep(20000);
		driver.findElement(By.id("j_username")).sendKeys("fxhadmin");
		driver.findElement(By.id("j_password")).sendKeys("fxhpass");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.navigate().to("https://ftm-control-center-ipc-keybank-st.ipc-keybank-nonprod-roks-b621399b0c4e883a72804711a921fd8d-i000.us-south.containers.appdomain.cloud/fxh/app");
		Thread.sleep(10000);
		//outbound Transmission page
		driver.findElement(By.xpath("//td[@data-automation-id='root/presentment-group']")).click();
		driver.findElement(By.xpath("//td[@data-automation-id='distribution/file-nav']")).click();
		Thread.sleep(10000);
		WebElement Outbound_framePath = driver.findElement(By.xpath("//iframe[@title='Outbound Transmissions']"));
		driver.switchTo().frame(Outbound_framePath);
		Select selectElm = new Select(driver.findElement(By.name("businessDayId")));
		selectElm.selectByVisibleText("0, 2023-02-03, 5, Check (Active)");
		Select selectfilter = new Select(driver.findElement(By.name("dataFilter.option")));
	    selectfilter.selectByVisibleText("Status");
	    Select filtervalue = new Select(driver.findElement(By.name("dataFilter.value")));
	    filtervalue.selectByVisibleText("Queued");
	    driver.findElement(By.id("gobutton")).click();
	    Thread.sleep(2000);
	    int No_outboundfiles=driver.findElements(By.xpath("//td[@id='Status']")).size();
	    Boolean isPresent = No_outboundfiles > 0;
	    //String transid_string=null;
	    Thread.sleep(5000);
	    
	    if(isPresent)
	    {
	    	String transid_string=null;
	    	for(int i=1;i<=No_outboundfiles;i++)
		    {
	    		driver.findElement(By.xpath("(//input[@id='selectionCheckbox'])["+i+"]")).click();
	    		if(i==1)
	    		{
	    			transid_string=driver.findElement(By.xpath("((//td[contains(@id,'Identifier')]))["+i+"]")).getText();
	    		}
	    		else
	    		{
	    		transid_string= transid_string+","+driver.findElement(By.xpath("((//td[contains(@id,'Identifier')]))["+i+"]")).getText();
	    		}
		    }
	    	System.out.println(transid_string);
	    	driver.findElement(By.xpath("(//img[@title='Selection Menu'])[1]")).click();
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//a[contains(text(),'Set status to transmitted')]")).click();
	    	Thread.sleep(20000);
	    	driver.findElement(By.xpath("//span[text()='Continue']")).click();
	    	String[] transidvalue = transid_string.split(",");
	    	
	    	Select selectfilter1 = new Select(driver.findElement(By.name("dataFilter.option")));
	    	selectfilter1.selectByValue("presentment_group_id");
	    	
	    	for(int i=0;i<No_outboundfiles;i++)
	    	{
	    		System.out.println(transidvalue[i]);
	    		driver.findElement(By.xpath("//input[@name='dataFilter.value']")).sendKeys(transidvalue[i]);
	    		driver.findElement(By.id("gobutton")).click();
	    		Thread.sleep(2000);
	    		System.out.println(driver.findElement(By.xpath("//td[@id='Status']")).getText());
	    		if(!driver.findElement(By.xpath("//input[@id='selectionCheckbox']")).isSelected())
	    		{
	    		  driver.findElement(By.xpath("//input[@id='selectionCheckbox']")).click();
	    		}
	    		driver.findElement(By.xpath("(//img[@title='Selection Menu'])[1]")).click();
	    		driver.findElement(By.xpath("//a[contains(text(),'Rebuild and release')]")).click();
	    		Thread.sleep(15000);
	    		driver.findElement(By.xpath("//input[@value='Build']")).click();
	    		Thread.sleep(15000);
	    		driver.findElement(By.xpath("//span[text()='Continue']")).click();
	    		Thread.sleep(10000);
	    		driver.findElement(By.xpath("//input[@name='dataFilter.value']")).clear();
	    		
	    	}
	    }
	}

}
