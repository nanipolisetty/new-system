package newInThisSystem;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_004 {
// delete an employee
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Set UP Naveen\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		Actions A= new Actions(driver);
		WebElement UN=driver.findElementByName("txtUserName");
		 WebElement PWD=driver.findElementByName("txtPassword");
		 WebElement Login =driver.findElementByName("Submit");
		 UN.sendKeys("qaplanet1");
		 PWD.sendKeys("lab1");
		 Login.click();	
		 driver.switchTo().frame("rightMenu");
		 int rc=driver.findElementsByXPath("//table/tbody/tr").size();
	
		 for(int i=1;i<=rc;i++){
               String xx=driver.findElementByXPath("//table/tbody/tr["+i+"]/td[2]").getText();
               
             System.out.println(xx);
               
			 if(xx.equals("8870")){
				 
			driver.findElementByXPath("//table/tbody/tr["+i+"]/td[1]").click();	 
			
		
			 }
			else
				continue;
			 }
			 
		 }
	
	}

