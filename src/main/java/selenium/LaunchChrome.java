package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\000QPC744\\chromedriver_win32\\chromedriver.exe");
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
		}

	}

}
