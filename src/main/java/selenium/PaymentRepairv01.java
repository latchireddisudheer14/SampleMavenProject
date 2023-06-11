package selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentRepairv01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/000QPC744/chromedriver_win32/chromedriver.exe");
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
				nam.sendKeys("FEDT_Include_MICR_STv131658222094088@frb.org.X9.37.PAYLOAD.v13");
				WebElement filter_button = driver.findElement(By.xpath("//span[@class='idxDialogActionBarEnd']/span[1]"));
				filter_button.click();
				Thread.sleep(5000);
				WebElement Rejects_warn= driver.findElement(By.xpath("//td[@colid='group.num_val_results' and @role='gridcell']/a"));
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
		  List<String> error_list = new ArrayList<String>();
		  List<String> fieldvaluelist = new ArrayList<String>();
		  List<String> temp_List = new ArrayList<String>();
		  List<String> tempfieldvalue_List = new ArrayList<String>();
		  Iterator<WebElement> payItr= pay_id_element.iterator();
		  int indx=2;
		  String[] repairvalue = {"225086014","986366447389215992","975698025777660391"};
		  while(payItr.hasNext())
		  {
			  String pay_id= (payItr.next()).getText();
			  if(pay_id.isEmpty())
				  continue;
			  String Erro_code=driver.findElement(By.xpath("//tbody/tr["+indx+"]/td[14]")).getText();
			  String fieldvalue=driver.findElement(By.xpath("//tbody/tr["+indx+"]/td[24]")).getText();
			  unq_trans_id.add(pay_id);
			  pay_id_List.add(pay_id);
			  error_list.add(Erro_code);
			  fieldvaluelist.add(fieldvalue);
			  //
			  indx=indx+2;
		  }
		  for(int i=0,j=0;i<fieldvaluelist.size();i++)
		  {
			  if(error_list.get(i).equalsIgnoreCase("EST0041"))
			  {
				  System.out.print("ignored field 4 repair value");
			  }
			  else if(fieldvaluelist.get(i).contains("*"))
			  {
				  fieldvaluelist.set(i,repairvalue[j]);
				  j++;
			  }
		  }
		  Iterator<String> erItr= error_list.iterator();
		  Iterator<String> payIdListItr= pay_id_List.iterator();
		  Iterator<String> tsItr= unq_trans_id.iterator();
		  Iterator<String> fieldItr= fieldvaluelist.iterator();
		  indx=1;
		  while(erItr.hasNext())
		  {
			  System.out.println(indx+" "+payIdListItr.next()+" "+erItr.next()+" "+fieldItr.next());
			  indx++;
		  }
		  driver.switchTo().defaultContent();
		//Payment Repair
		driver.findElement(By.xpath("//td[@data-automation-id='root/processing-group']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@data-automation-id='processing/pay-repair-group']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@data-automation-id='payrepair/izq-operator-nav']")).click();
		Thread.sleep(10000);
		WebElement repair_frame= driver.findElement(By.xpath("//iframe[@title='Forward Payments']"));
		driver.switchTo().frame(repair_frame);
		indx=0;
		
		int rid=0;
		try
		{
			WebElement skip_button=driver.findElement(By.xpath("//input[@id='nextbutton']"));
			WebElement payment_id_Element= driver.findElement(By.xpath("//div[@id='payidfield']/span"));
			String temp= payment_id_Element.getText();
			System.out.println("Before first while loop"+temp.substring(12));
			while(skip_button.isEnabled())
			{
				System.out.println("Inside first while loop");
				if(pay_id_List.contains(temp.substring(12)))
				{
					String ts_pay_id= temp.substring(12);
					System.out.println(ts_pay_id);
					for(int i=0,j=0;i<pay_id_List.size();i++)
					{
						if(pay_id_List.get(i).equalsIgnoreCase(ts_pay_id))
						{
							temp_List.add(error_list.get(i));
							tempfieldvalue_List.add(fieldvaluelist.get(i));
							System.out.println("Error code"+temp_List.get(j)+"Field value:"+tempfieldvalue_List.get(j));
							j++;
						}	
					}
					for(int i=0;i<temp_List.size();i++)
					{
						String temp_error_code=temp_List.get(i);
						System.out.println(temp_error_code);
						switch(temp_error_code)
						{
						   case "EST0071":
							   System.out.println("Inside  on EST0071 decision");
							   driver.findElement(By.xpath("//input[@id='sn']")).clear();
							   driver.findElement(By.xpath("//input[@id='sn']")).sendKeys(tempfieldvalue_List.get(i));
							   rid++;
							   break;
						   case "EST0031":
							   System.out.println("Inside  on EST0031 decision");
							   driver.findElement(By.xpath("//input[@id='account']")).clear();
							   driver.findElement(By.xpath("//input[@id='account']")).sendKeys(tempfieldvalue_List.get(i));
							   rid++;
							   break;
						   default :
							   System.out.println("click nothing:"+temp_error_code);
						}
					}
					driver.findElement(By.xpath("//input[@id='acceptbutton']")).click();
					Thread.sleep(5000);
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
					   temp_List.clear();
					   tempfieldvalue_List.clear();
					  
				}
				else
				{
				  System.out.println("Inside id 2nd else conditon do skip:"+temp.substring(12));
				  skip_button.click();
				  Thread.sleep(3000);
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
		catch(UnhandledAlertException u)
		{
			System.out.println("Inside Unhandled catch block"+u);
			
	        
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println("Completed Sucessfully");
	
	
	
	}
}
