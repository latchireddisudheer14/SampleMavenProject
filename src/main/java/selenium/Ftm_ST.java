package selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.*;

public class Ftm_ST {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/000QPC744/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://ftm-control-center-ipc-keybank-sit.ipc-keybank-nonprod-roks-b621399b0c4e883a72804711a921fd8d-i000.us-south.containers.appdomain.cloud/fxh/login.jsp#home");
		//Thread.sleep(20000);
		driver.findElement(By.id("j_username")).sendKeys("fxhadmin");
		driver.findElement(By.id("j_password")).sendKeys("fxhpass");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.navigate().to("https://ftm-control-center-ipc-keybank-sit.ipc-keybank-nonprod-roks-b621399b0c4e883a72804711a921fd8d-i000.us-south.containers.appdomain.cloud/fxh/app");
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//td[@title='Origination & Receipt']")).click();
//		Physical Transmission button
		WebElement physical_transmission= driver.findElement(By.xpath("//*[@data-automation-id='gateway/files-nav']"));	
		physical_transmission.click();		
		//Inbound Physical Transmission
		WebElement framePath = driver.findElement(By.xpath("//iframe[@title='Inbound Physical Transmissions']"));
		driver.switchTo().frame(framePath);
		//Select selectElm = new Select(driver.findElement(By.name("businessDayId")));
		//selectElm.selectByValue("-1");
		//selectElm.s
		//WebElement go_button= driver.findElement(By.id("gobutton"));
		//go_button.click();
		List<WebElement> listnames= driver.findElements(By.xpath("//td[@headers='Original Transmission Name']"));
		List<WebElement> statusList= driver.findElements(By.xpath("//td[@headers='Status']"));
		Iterator<WebElement> itr = listnames.iterator();
		Iterator<WebElement> sitr = statusList.iterator();
		String col_name=null;
		String stat=null;
		while(itr.hasNext())
		{
			WebElement nm= itr.next();
		        WebElement snm= sitr.next();
			col_name =nm.getText();
		        //stat=snm.getText();
			if(col_name.equalsIgnoreCase("FEDT_Include_MICR123_1658222094088@frb.org.X9.37.PAYLOAD.000.dat"))
			{
		                stat=snm.getText();
				System.out.println("Test passed:  "+col_name+"Status:"+stat);
			}
		}

		//switch to default content
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//td[@title='Origination & Receipt']")).click();
		
		// Inbound Transmission
		WebElement transmission= driver.findElement(By.xpath("//*[@data-automation-id='txs/transmissions-nav']"));
		transmission.click();
		Thread.sleep(40000);
		WebElement inbound_transmis_frame = driver.findElement(By.xpath("//iframe[@title='Inbound Transmissions']"));
		driver.switchTo().frame(inbound_transmis_frame);
		WebElement def_Filter = driver.findElement(By.xpath("//span[@title='Define filter']"));
		def_Filter.click();
		//First drop down
		WebElement filterarrow = driver.findElement(By.xpath("//div[@class='gridxFilterRules']/div/div[1]/div[2]/table/tbody/tr/td[2]"));
		filterarrow.click();
		//select Original name
		WebElement past= driver.findElement(By.xpath("//tr[@aria-label='Original Name ']"));
		past.click();
		//enter file name
		WebElement nam= driver.findElement(By.xpath("//div[@class='gridxFilterRules']/div/div[4]/div[1]/div[2]/div[1]/div[2]/input[1]"));
		nam.sendKeys("FEDT_Include_MICR123_1658222094088@frb.org.X9.37.PAYLOAD.000");
		//filter button
		WebElement filter_button = driver.findElement(By.xpath("//span[@class='idxDialogActionBarEnd']/span[1]"));
		filter_button.click();
		Thread.sleep(5000);
		WebElement condition= driver.findElement(By.xpath("//td[@colid='group.condition' and @role='gridcell']"));
		System.out.println(condition.getText());
		WebElement processing_batch_link = driver.findElement(By.xpath("//td[@colid='num_proc_presentments' and @role='gridcell']/a"));
		processing_batch_link.click();
		Thread.sleep(35000);
		
		driver.switchTo().defaultContent();
		
		
		//processing_batch frame
		WebElement process_batch_frame= driver.findElement(By.xpath("//iframe[@title='Processing Batches / ICLs']"));
		driver.switchTo().frame(process_batch_frame);
		//WebElement more = driver.findElement(By.xpath("//div[@id='processingBatchesGrid']/div[2]/div/table/tbody/tr/td/div/span[4]/span[1]"));
		//more.click();
		WebElement arg_xpath= driver.findElement(By.xpath("//td[@colid='e.entry_num' and @role='gridcell']/a"));
		System.out.println(arg_xpath.getText());
	}
}
