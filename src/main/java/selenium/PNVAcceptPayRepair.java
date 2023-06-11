package selenium;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PNVAcceptPayRepair {
	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/000QPC744/ChromeDriverV112/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ftm-control-center-ipc-keybank-st.ipc-keybank-nonprod-roks-b621399b0c4e883a72804711a921fd8d-i000.us-south.containers.appdomain.cloud/fxh/login.jsp#home");
		Thread.sleep(20000);
		driver.findElement(By.id("j_username")).sendKeys("fxhadmin");
		driver.findElement(By.id("j_password")).sendKeys("fxhpass");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.navigate().to("https://ftm-control-center-ipc-keybank-st.ipc-keybank-nonprod-roks-b621399b0c4e883a72804711a921fd8d-i000.us-south.containers.appdomain.cloud/fxh/app");
		Thread.sleep(10000);
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//td[@title='Origination & Receipt']")).click();
		// Inbound Transmission
				WebElement transmission= driver.findElement(By.xpath("//*[@data-automation-id='txs/transmissions-nav']"));
				transmission.click();
				Thread.sleep(40000);
				WebElement inbound_transmis_frame = driver.findElement(By.xpath("//iframe[@title='Inbound Transmissions']"));
				driver.switchTo().frame(inbound_transmis_frame);
				WebElement def_Filter = driver.findElement(By.xpath("//span[@title='Define filter']"));
				def_Filter.click();
				WebElement filterarrow = driver.findElement(By.xpath("//div[@class='gridxFilterRules']/div/div[1]/div[2]/table/tbody/tr/td[2]"));
				filterarrow.click();
				WebElement past= driver.findElement(By.xpath("//tr[@aria-label='Original Name ']"));
				past.click();
				driver.findElement(By.xpath("//div[@class='gridxFilterRules']/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]")).click();
				driver.findElement(By.xpath("//tr[@aria-label='equals ']")).click();
				WebElement nam= driver.findElement(By.xpath("//div[@class='gridxFilterRules']/div/div[4]/div[1]/div[2]/div[1]/div[2]/input[1]"));
				nam.sendKeys("Loop.SD-PNVR.P.R8888.N1003.D230412.T022028441");
				WebElement filter_button = driver.findElement(By.xpath("//span[@class='idxDialogActionBarEnd']/span[1]"));
				filter_button.click();
				Thread.sleep(5000);
				WebElement processing_batch_link = driver.findElement(By.xpath("//td[@colid='num_proc_presentments' and @role='gridcell']/a"));
				processing_batch_link.click();
				Thread.sleep(35000);
				driver.switchTo().defaultContent();
				//processing batches
				WebElement process_frame = driver.findElement(By.xpath("//iframe[@title='Processing Batches / ICLs']"));
				driver.switchTo().frame(process_frame);
				WebElement payRepairCol= driver.findElement(By.xpath("//td[@colid='s.repaired_state' and @role='gridcell']"));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView()", payRepairCol);
				Boolean isPresent = driver.findElements(By.xpath("//td[@colid='s.repaired_state' and @role='gridcell']/img[@alt='In progress']")).size() > 0;
				
			if(isPresent)
			{	
				WebElement Rejects_warn= driver.findElement(By.xpath("//td[@colid='p.num_val_results']/a"));
				js.executeScript("arguments[0].scrollIntoView()", Rejects_warn);
				Rejects_warn.click();
				driver.switchTo().defaultContent();
				Thread.sleep(10000);
		//Rejects and warnings
		  WebElement Reject_Frame= driver.findElement(By.xpath("//iframe[@title='Rejects and Warnings Report']"));
		  driver.switchTo().frame(Reject_Frame);
		  List<WebElement> pay_id_element = driver.findElements(By.xpath("//tbody/tr/td[8]"));
		  System.out.println(pay_id_element.size());
		  SortedSet<String> unq_trans_id= new TreeSet<String>();
		  List<String> pay_id_List = new ArrayList<String>();
		  Iterator<WebElement> payItr= pay_id_element.iterator();
		  while(payItr.hasNext())
		  {
			  String pay_id= (payItr.next()).getText();
			  if(pay_id.isEmpty())
				  continue;
			  unq_trans_id.add(pay_id);
			  pay_id_List.add(pay_id);
		  }
		  for(int i=0;i<pay_id_List.size();i++)
		  {
			  System.out.println(pay_id_List.get(i));
		  }
		  
		  driver.switchTo().defaultContent();
			//Payment Repair
			driver.findElement(By.xpath("//td[@data-automation-id='root/processing-group']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//td[@data-automation-id='processing/pay-repair-group']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//td[@data-automation-id='payrepair/izq-operator-nav']")).click();
			Thread.sleep(15000);
			WebElement repair_frame= driver.findElement(By.xpath("//iframe[@title='Forward Payments']"));
			driver.switchTo().frame(repair_frame);
			WebElement skip_button=driver.findElement(By.xpath("//input[@id='nextbutton']"));
			WebElement payment_id_Element= driver.findElement(By.xpath("//div[@id='payidfield']/span"));
			String temp= payment_id_Element.getText();
			String prevPayid="zero";
			System.out.println("Before first while loop"+temp.substring(12));
			try
			{
			 while(skip_button.isEnabled())
			 {
				System.out.println("Inside first while loop");
				if(pay_id_List.contains(temp.substring(12)))
				{
					if(prevPayid.equalsIgnoreCase(temp.substring(12)))
					{
						throw new Exception("Payment repair not done");
					}
				   else 
				   {
					prevPayid=temp.substring(12);
				    System.out.println(temp.substring(12));
					driver.findElement(By.xpath("//input[@id='field_6']")).sendKeys("0");
					driver.findElement(By.xpath("//input[@id='acceptbutton']")).click();
					Thread.sleep(8000);
					try
					{
						System.out.println("Inside try block");
						Alert alert = driver.switchTo().alert();
				        String alertText = alert.getText();
				        System.out.println("Alert data: " + alertText);
				        alert.accept();
				        Thread.sleep(6000);
				        alert.accept();
				        Thread.sleep(6000);
					}
					catch(NoAlertPresentException n)
					{
						System.out.println("No alert present");
					}
				  }
				}
				else
				{
				  System.out.println("Inside id 2nd else conditon do skip:"+temp.substring(12));
				  skip_button.click();
				  Thread.sleep(8000);
				  try
					{
						System.out.println("Inside try block");
						Alert alert = driver.switchTo().alert();
				        String alertText = alert.getText();
				        System.out.println("Alert data: " + alertText);
				        alert.accept();
				        Thread.sleep(6000);
				        alert.accept();
				        Thread.sleep(6000);
					}
					catch(NoAlertPresentException n)
					{
						System.out.println("No alert present");
					}
				}
				payment_id_Element= driver.findElement(By.xpath("//div[@id='payidfield']/span"));
				temp=payment_id_Element.getText();
			}
		  }
		  catch(Exception e)
		  {
			System.out.println(e.getMessage());
		  }
		}	
	}

}
