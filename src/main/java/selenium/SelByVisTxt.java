package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.support.ui.Select;

public class SelByVisTxt {

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
		driver.findElement(By.xpath("//td[@title='Origination & Receipt']")).click();
//		Physical Transmission button
		WebElement physical_transmission= driver.findElement(By.xpath("//*[@data-automation-id='gateway/files-nav']"));	
		physical_transmission.click();
		Thread.sleep(15000);
		
		WebElement framePath = driver.findElement(By.xpath("//iframe[@title='Inbound Physical Transmissions']"));
		driver.switchTo().frame(framePath);
		Select selectElm = new Select(driver.findElement(By.name("businessDayId")));
	    selectElm.selectByVisibleText("0, 2022-11-22, 2, Check (Active)");
	    Select selectfilter = new Select(driver.findElement(By.name("dataFilter.option")));
	    selectfilter.selectByVisibleText("Original Transmission Name");
	    Select selectOperator = new Select(driver.findElement(By.name("dataFilter.operator")));
	    selectOperator.selectByValue("like");
		WebElement go_button= driver.findElement(By.id("gobutton"));
		go_button.click();


	}

}
