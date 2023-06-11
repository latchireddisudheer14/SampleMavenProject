package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ActivateBusinessDay {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/000QPC744/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ftm-control-center-ipc-keybank-sit.ipc-keybank-nonprod-roks-b621399b0c4e883a72804711a921fd8d-i000.us-south.containers.appdomain.cloud/fxh/login.jsp#home");
		Thread.sleep(20000);
		driver.findElement(By.id("j_username")).sendKeys("fxhadmin");
		driver.findElement(By.id("j_password")).sendKeys("fxhpass");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.navigate().to("https://ftm-control-center-ipc-keybank-sit.ipc-keybank-nonprod-roks-b621399b0c4e883a72804711a921fd8d-i000.us-south.containers.appdomain.cloud/fxh/app");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//td[@data-automation-id='root/system-group']")).click();
		driver.findElement(By.xpath("//td[@data-automation-id='txs/bday-nav']")).click();
		Thread.sleep(5000);
		WebElement Bus_Frame= driver.findElement(By.xpath("//iframe[@title='Business Days']"));
		driver.switchTo().frame(Bus_Frame);
		String bus_Date="2023-02-16";
		String catgry="4";
		String state = driver.findElement(By.xpath("//td[contains(text(),'"+bus_Date+"')]/following-sibling::td[@id='category' and contains(text(),'"+catgry+"')]/following-sibling::td[@id='state']")).getText();
	
	    if(state.equalsIgnoreCase("Open"))
	    {
	    	System.out.println("Open");
	    	driver.findElement(By.xpath("//td[contains(text(),'"+bus_Date+"')]/following-sibling::td[@id='category' and contains(text(),'"+catgry+"')]//parent::tr//td/a/img[@title='Selection Menu']")).click();
	    	driver.findElement(By.xpath("//td[contains(text(),'"+bus_Date+"')]/following-sibling::td[@id='category' and contains(text(),'"+catgry+"')]//parent::tr//td[2]/div/table/tbody/tr/td/a[contains(text(),'Activate')]")).click();
	    	Alert alert = driver.switchTo().alert();
	        String alertText = alert.getText();
	        System.out.println("Alert data: " + alertText);
	        alert.accept();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//input[@value='Refresh']"));
	        Thread.sleep(10000);
	        
	        
	    }
	    else
	    {
	    	System.out.println(state);
	    }
	    Boolean isPresent = driver.findElements(By.xpath("//td[contains(text(),'"+bus_Date+"')]/following-sibling::td[@id='category' and contains(text(),'"+catgry+"')]/following-sibling::td[@id='current']/img")).size() > 0;
        if(!isPresent)
        {
        	driver.findElement(By.xpath("//span[contains(text(),'Set Current Date')]")).click();
        	Thread.sleep(5000);
        	Select selectbussDate = new Select(driver.findElement(By.name("date")));
        	selectbussDate.selectByValue(bus_Date);
        	driver.findElement(By.xpath("//input[@name='Set Current']")).click();
        	Thread.sleep(5000);
        }
	    driver.switchTo().defaultContent();
	
	
	}
}
