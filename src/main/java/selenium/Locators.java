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

public class Locators {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/000QPC744/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ftm-ctrl-fc-inst-ftm-dev.keybank-ftm-97faa12d9f46121470489ed05b8cbed7-0000.us-south.containers.appdomain.cloud/fxh/login.jsp");
		Thread.sleep(20000);
		//driver.navigate().to("https://jsbin.com/usidix/1");
				/*driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
				String alertMessage=driver.switchTo().alert().getText();
				System.out.println(alertMessage);
				driver.switchTo().alert().accept();		*/
				//driver.close();
				//String tagName="";
				//String webeltag="";
				//WebElement elm= driver.findElement(By.id("email"));
				//tagName= driver.findElement(By.id("email")).getTagName();
				//System.out.println(tagName);
				//webeltag= 
				//elm.sendKeys("Hello test");
				//System.out.println("webelemetn tag:"+webeltag);

		
		//findElement method sample
		/*WebElement elmradio = driver.findElement(By.id("Yes"));
		elmradio.click();
		WebElement elmCheckButton= driver.findElement(By.id("buttoncheck"));
		*/
		
		//findElements
		/*List<WebElement> listElm = driver.findElements(By.name("name"));
		WebElement elmReset = driver.findElement(By.xpath("//input[@value='Reset']"));
		System.out.println(listElm.size());
		for(int i=0;i<listElm.size();i++)
		{
			listElm.get(i).click();
			elmCheckButton.click();
			Thread.sleep(5000);
			elmReset.click();	
		}*/
		
		
		//Select from drop down
		/*Select selectElm = new Select(driver.findElement(By.name("country")));
		selectElm.selectByValue("INDIA");*/
		
		
		
		//Mouse Action
		/*WebElement home = driver.findElement(By.linkText("Home"));
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(home).build();
		mouseOverHome.perform();*/
		
		
		//Xpath
		/*WebElement X_RoundTrip= driver.findElement(By.xpath("//*[text()='round trip']"));
		//String alertMessage=driver.switchTo().alert().getText();
		//System.out.println(alertMessage);
		X_RoundTrip.click();*/
		
		
		//select calendar
		/*String expected_text="June 2022";
		driver.findElement(By.xpath("//input[@id='checkin']")).click();
		String text=driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
		System.out.println(text);
		System.out.println(text.equals(expected_text)==false);
		while(text.equals(expected_text)==false)
		{
			driver.findElement(By.xpath("//body[1]/div[3]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
			text=driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
		}
		System.out.println(text);
		
		driver.findElement(By.xpath("//body[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[contains(text(),'20')]")).click();
		*/
		
		
		//Irctc calendar
		/*driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='ng-tns-c59-10 ui-calendar']")).click();
		driver.findElement(By.xpath("//td[@class='ng-tns-c59-10 ng-star-inserted']//a[text()='12']")).click();
		*/
		//String text= driver.findElement(By.xpath("//*[@class='ui-datepicker-month ng-tns-c59-10 ng-star-inserted']")).getText();
		//System.out.println(text);
		
		//FTM
		driver.findElement(By.id("j_username")).sendKeys("testuser1");
		driver.findElement(By.id("j_password")).sendKeys("testpass");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.navigate().to("https://ftm-ctrl-fc-inst-ftm-dev.keybank-ftm-97faa12d9f46121470489ed05b8cbed7-0000.us-south.containers.appdomain.cloud/fxh/app");
		Thread.sleep(10000);
		//Organination Receipt
		driver.findElement(By.xpath("//td[@title='Origination & Receipt']")).click();
		
		// Inbound Transmission

			/*WebElement transmission= driver.findElement(By.xpath("//*[text()='Transmissions']"));
			transmission.click();
			Thread.sleep(70000);*/
		
		
		//ICL_Batch
				/*
				 WebElement ICL_Batch = driver.findElement(By.xpath("//td[@data-automation-id='orig-receipt/batches-group']"));
				ICL_Batch.click();
				*/
			
				//Mouse Action				
				//WebElement proc_batch = driver.findElement(By.xpath("//td[@data-automation-id='txs/processing-batches-nav']"));
				//proc_batch.getTagName();
				//Actions builder = new Actions(driver);
				//builder.moveToElement(ICL_Batch);
				/*Thread.sleep(5000);
				WebElement inbound = driver.findElement(By.xpath("//*[text()='Inbound']"));
				builder.moveToElement(proc_batch);
				builder.click();*/
				//builder.build().perform();
				
		//
			//	driver.findElement(By.xpath("//td[@title='Processing & Remediation']")).click();
				//driver.findElement(By.xpath("//*[text()='Duplicate Detect']")).click();
				
				//Calender
				//"//table/tbody/tr/td[@aria-label="May 30, 2022"]"
		
			
			//Swiitch Frame	Inbound Transmission
		/*WebElement frame_path= driver.findElement(By.xpath("//iframe[@title='Inbound Transmissions']"));
		driver.switchTo().frame(frame_path);
		*/
			
			
		//	Physical Transmission button
			WebElement physical_transmission= driver.findElement(By.xpath("//*[@data-automation-id='gateway/files-nav']"));	
		   physical_transmission.click();
			Thread.sleep(15000);
			
		//Switch Frame Physical Transmission
		WebElement physical_Transmission_frame= driver.findElement(By.xpath("//iframe[@title='Inbound Physical Transmissions']"));
		driver.switchTo().frame(physical_Transmission_frame);	
		
		
		
		//Start Business day
		Select selectElm = new Select(driver.findElement(By.name("businessDayId")));
		selectElm.selectByValue("-1");
		
		WebElement go_button= driver.findElement(By.id("gobutton"));
		go_button.click();
		
		/*WebElement f_name= driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[27]/td[19]"));
		String col_name=f_name.getText();
		System.out.println(col_name);
		System.out.println(col_name.equalsIgnoreCase("ipdRefGoodFlow011.dat"));
		*/
		
		//List of webElements
		List<WebElement> listnames= driver.findElements(By.xpath("/html/body/div/table/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr/td[19]"));
		Iterator<WebElement> itr = listnames.iterator();
		String col_name = null ;
		while(itr.hasNext())
		{
			WebElement nm= itr.next();
			col_name =nm.getText();
			if(col_name.equalsIgnoreCase("ipdRefGoodFlow011.dat"))
			{
				System.out.println("Test passed:  "+col_name);
				break;
			}
		}
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//td[@title='Origination & Receipt']")).click();
		
		//Inbound Transmission
		WebElement transmission= driver.findElement(By.xpath("//*[@data-automation-id='txs/transmissions-nav']"));
		transmission.click();
		Thread.sleep(25000);
		WebElement inbound_transmis_frame = driver.findElement(By.xpath("//iframe[@title='Inbound Transmissions']"));
		driver.switchTo().frame(inbound_transmis_frame);
		
		//Click define filter
			WebElement def_Filter = driver.findElement(By.xpath("//*[@id='dijit_form_Button_1']"));
			def_Filter.click();
			
		//type_2 filter
			WebElement filterarrow = driver.findElement(By.xpath("//div[@class='gridxFilterRules']/div/div[2]/div[2]/table/tbody/tr/td[2]"));
			filterarrow.click();
			
		//select past
			WebElement past= driver.findElement(By.xpath("//tr[@aria-label='past ']"));
			past.click();
			
			WebElement days_field= driver.findElement(By.xpath("//div[@class='gridxFilterPaneFieldWrapper gridxFilterPaneDatetimePastWrapper']/div/div[2]/div[1]/div/input[1]"));
			days_field.sendKeys("20");
					
		
		// Click Filter button
			WebElement filter_button = driver.findElement(By.xpath("//span[@id='dijit_form_Button_2']"));
			filter_button.click();
			Thread.sleep(5000);
			
			List<WebElement> filenames= driver.findElements(By.xpath("//td[@colid='f.cust_filename']"));
			List<WebElement> transIDs= driver.findElements(By.xpath("//td[@colid='group.presentment_group_id']"));
			
			Iterator<WebElement> nameItr= filenames.iterator();
			Iterator<WebElement> idItr= transIDs.iterator();
			String fname=null;
			String transid=null;
			while(nameItr.hasNext())
			{
				WebElement fname_path= nameItr.next();
				WebElement transid_path= idItr.next();
				fname= fname_path.getText();
				if(fname.equalsIgnoreCase("ipdRefGoodFlow011"))
				{
					transid=transid_path.getText();
					System.out.println("Test passed:  "+fname+"  TransID: "+transid);
					break;
				}	           				
			}
			
			System.out.println("Outsideloop"+transid);
			
			WebElement condition_path= driver.findElement(By.xpath("//div[@rowid="+transid+" and @class='gridxRow']/table/tbody/tr/td[@colid='group.condition']"));
			String condition= condition_path.getText();
			System.out.println("condition:"+condition);
			
			WebElement rejec_warn_path = driver.findElement(By.xpath("//div[@rowid="+transid+" and @class='gridxRow']/table/tbody/tr/td[@colid='group.num_val_results']/a"));
			String rejec_warn= rejec_warn_path.getText();
			System.out.println("Reject and warnings:"+rejec_warn);
			
			WebElement process_batch = driver.findElement(By.xpath("//div[@rowid="+transid+" and @class='gridxRow']/table/tbody/tr/td[@colid='num_proc_presentments']/a"));
			process_batch.click();
			Thread.sleep(35000);
			
			driver.switchTo().defaultContent();
			
			
			//processing_batch frame
			WebElement process_batch_frame= driver.findElement(By.xpath("//iframe[@title='Processing Batches / ICLs']"));
			driver.switchTo().frame(process_batch_frame);
			
			WebElement col_status_path= driver.findElement(By.xpath("//div[@rowid='304']/table/tbody/tr/td[@colid='p.status']"));
			
			String status = col_status_path.getText();
			System.out.println("Transaction status: "+status);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
		
			WebElement no_trans_path= driver.findElement(By.xpath("//div[@rowid='304']/table/tbody/tr/td[@colid='p.total_txns']/a"));
			
			js.executeScript("arguments[0].scrollIntoView()", no_trans_path);
			String no_trans= no_trans_path.getText();
			System.out.println("No Transactions: "+ no_trans);
			no_trans_path.click();
		
			// Get rejects and warnings
			//WebElement rej_Warnings= driver.findElement(By.xpath("//div[@rowid='184']/table[@class='gridxRowTable']/tbody/tr/td[@aria-describedby='transmissionsGrid-group.num_val_results']/a"));
			/*WebElement rej_Warnings= driver.findElement(By.xpath("//*[@id='transmissionsGrid']/div[3]/div[2]/div[2]/table/tbody/tr/td[13]/a"));
			rej_Warnings.click();
			*/
			}

	
	
}
