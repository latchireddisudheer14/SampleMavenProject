package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dupdetect {

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
		// Inbound Transmission
				WebElement transmission= driver.findElement(By.xpath("//*[@data-automation-id='txs/transmissions-nav']"));
				transmission.click();
				Thread.sleep(40000);
				WebElement inbound_transmis_frame = driver.findElement(By.xpath("//iframe[@title='Inbound Transmissions']"));
				driver.switchTo().frame(inbound_transmis_frame);
				WebElement def_Filter = driver.findElement(By.xpath("//span[@title='Define filter']"));
				def_Filter.click();
				// Add filter button
				driver.findElement(By.xpath("//span[@title='Add Filter Rule']")).click();
				
				//First drop down
				WebElement filterarrow = driver.findElement(By.xpath("//div[@class='gridxFilterRules']/div[2]/div[1]/div[2]/table/tbody/tr/td[2]"));
				filterarrow.click();
				//select Original name
				WebElement past= driver.findElement(By.xpath("//tr[@aria-label='Original Name ']"));
				past.click();
				//enter file name
				WebElement nam= driver.findElement(By.xpath("//div[@class='gridxFilterRules']/div[2]/div[4]/div[1]/div[2]/div[1]/div[2]/input[1]"));
				nam.sendKeys("FEDT_Include_DUP_W1658247466676@frb.org.X9.37.PAYLOAD.000");
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
				WebElement process_batch_frame= driver.findElement(By.xpath("//iframe[@title='Processing Batches / ICLs']"));
				driver.switchTo().frame(process_batch_frame);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				WebElement dupReview= driver.findElement(By.xpath("//td[@colid='s.dup_reviewed_state' and @role='gridcell']"));
				js.executeScript("arguments[0].scrollIntoView()", dupReview);
				Boolean isPresent = driver.findElements(By.xpath("//td[@colid='s.dup_reviewed_state' and @role='gridcell']/img[@alt='In progress']")).size() > 0;
				//WebElement dupReviewed_inProgress= driver.findElement();
				driver.switchTo().defaultContent();
				if(isPresent)
				{
					String file_name="FEDT_DUP_16582474SHR@frb.org.X9.37.PAYLOAD.000";
					System.out.println("Element is Not Reviewed ");
					driver.findElement(By.xpath("//td[@data-automation-id='root/processing-group']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//td[@data-automation-id='processing/dupdetect-group']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//td[@data-automation-id='processing/dupdetect/manage-dups-group']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//td[@data-automation-id='dupdetect/batches-nav']")).click();
					Thread.sleep(10000);
					WebElement UOWFrame = driver.findElement(By.xpath("//iframe[@title='Units of Work']"));
					driver.switchTo().frame(UOWFrame);
					driver.findElement(By.xpath("//input[@name='startdate']")).clear();
					driver.findElement(By.xpath("//input[@name='startdate']")).sendKeys("12/5/22");
					driver.findElement(By.xpath("//input[@name='starttime']")).clear();
					driver.findElement(By.xpath("//input[@name='starttime']")).sendKeys("12:00 AM");
					driver.findElement(By.xpath("//input[@name='enddate']")).clear();
					driver.findElement(By.xpath("//input[@name='enddate']")).sendKeys("12/5/22");
					driver.findElement(By.xpath("//input[@name='endtime']")).clear();
					driver.findElement(By.xpath("//input[@name='endtime']")).sendKeys("11:59 PM");
					//driver.findElement(By.xpath("//input[@id='showallbox']")).click();
					driver.findElement(By.xpath("//input[@value='Show unit of work list']")).click();
					Thread.sleep(5000);
					/*WebElement Not_Duplicate_button= driver.findElement(By.xpath("//td[contains(text(),'"+file_name+"')]/following-sibling::td/a/img[@title='All not Duplicates']"));
					Not_Duplicate_button.click();
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();
					driver.findElement(By.xpath("//div[contains(text(),'Processing Batches / ICLs')]")).click();
					Thread.sleep(3000);
					driver.switchTo().frame(process_batch_frame);
					driver.findElement(By.xpath("//span[@id='processingBatchesGrid_Refresh']")).click();
					Thread.sleep(2000);
					System.out.println(driver.findElement(By.xpath("//td[@colid='s.dup_reviewed_state' and @role='gridcell']/img[@alt='Complete']")).isDisplayed());
					*/
			
					
				}
				else
					System.out.println("Element is not Present");
	}

}
