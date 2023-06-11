package selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.*;
public class CPCS {

	public static void main(String[] args) throws Exception{
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
		driver.findElement(By.xpath("//td[@title='Financial Management']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-automation-id='fin-mgt/settlement-group']//*[text()='Settlement']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-automation-id='fin-mgt/settlement/inbound-group']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@data-automation-id='settlement/cpcs-nav']")).click();
		Thread.sleep(5000);
		WebElement CPCS_Frame= driver.findElement(By.xpath("//iframe[@title='CPCS']"));
		driver.switchTo().frame(CPCS_Frame);
		driver.findElement(By.name("accumDate")).clear();
		driver.findElement(By.name("accumDate")).sendKeys("11/22/22");
		driver.findElement(By.xpath("//input[@name='Search']")).click();
	}

}
