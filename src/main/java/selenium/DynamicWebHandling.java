package selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\000QPC744\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		
		
		//find no of rows
		/*List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
		int siz=list.size();
		System.out.println(siz);*/
		
		
		//find max current price
		double max=0;
		List<WebElement> currPrice= driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[4]"));
		Iterator<WebElement> itr= currPrice.iterator();
		while(itr.hasNext())
		{
			WebElement company= itr.next();
			String txt_Currprice= company.getText();
			double price= Double.parseDouble(txt_Currprice);
			if(price>max)
				max=price;
			
		}
		System.out.println(max);

	}

}
