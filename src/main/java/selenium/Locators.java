package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/000QPC744/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.facebook.com");
		//driver.navigate().to("https://jsbin.com/usidix/1");
		driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
		String alertMessage=driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();		
		//driver.close();
		//String tagName="";
		//String webeltag="";
		//WebElement elm= driver.findElement(By.id("email"));
		//tagName= driver.findElement(By.id("email")).getTagName();
		//System.out.println(tagName);
		//webeltag= 
		//elm.sendKeys("Hello test");
		//System.out.println("webelemetn tag:"+webeltag);
	}

}
