package newInThisSystem;

import java.util.List;

import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TC_002 {
public static void main(String[] args) throws InterruptedException  {
	int a=1;
	System.setProperty("webdriver.chrome.driver", "E:\\Set UP Naveen\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	Actions A= new Actions(driver);
	driver.get("http://apps.qaplanet.in/qahrm/login.php");
	WebElement UN=driver.findElementByName("txtUserName");
	 WebElement PWD=driver.findElementByName("txtPassword");
	 WebElement Login =driver.findElementByName("Submit");
	 UN.sendKeys("qaplanet1");
	 PWD.sendKeys("lab1");
	 Login.click();

	 A.moveToElement(driver.findElementByXPath("//span[@class='drop current']")).perform();
	 A.click(driver.findElementByXPath("//span[contains(text(),'Add Employee')]")).perform();
	 driver.switchTo().frame("rightMenu");
	 String comparison=driver.findElementByName("txtEmployeeId").getAttribute("value");
	 System.out.println(comparison);
	 Thread.sleep(1000);
/*	 driver.switchTo().frame("rightMenu");*/
	 driver.findElementByXPath("//input[@class='savebutton']").click();
	 String alertText=driver.switchTo().alert().getText();
	 if(alertText.equals("Last Name Empty!")) {
		 
		 System.out.println("Message displayed as Last Name Empty!");
	 }
		 else
			 System.out.println("failed to display alert message");

	 driver.switchTo().alert().accept();
	 Thread.sleep(1000);
	 driver.findElementByName("txtEmpLastName").sendKeys("Quinn");


	 driver.findElementByXPath("//div[@class='formbuttons']/input[@id='btnEdit']").click();
	// driver.findElementByXPath("//input[@id='btnEdit']").click();
	 String alertText1=driver.switchTo().alert().getText();
	System.out.println(alertText1);
	
	driver.switchTo().alert().accept();
	driver.findElementByName("txtEmpFirstName").sendKeys("Harley");

	 driver.findElementByXPath("//input[@id='btnEdit']").click();
WebElement pDpage= driver.findElementByXPath("//div[@class='mainHeading']/h2[contains(text(),'Personal Details')]");
if(pDpage.getText().equals("Personal Details")){
System.out.println("Personal Details Page displayed successfully");
}
else
{
	System.out.println("failed to display Personal Details page");
}
//switch to parent frame
driver.switchTo().parentFrame();
//focus on pim
A.moveToElement(driver.findElementByXPath("//span[contains(text(),'PIM')]")).perform();
A.click(driver.findElementByXPath("//span[contains(text(),'Employee List')]")).perform();
Thread.sleep(1000);

// switch to employee information frame
driver.switchTo().frame("rightMenu");
WebElement Einfo=driver.findElementByXPath("//div[@class='mainHeading']/h2");
if(Einfo.getText().equals("Employee Information"))
	
	System.out.println("Employee information page availabe");
	else 
		System.out.println("Failed to display Employee information page");	
int rc=driver.findElementsByXPath("//table/tbody/tr").size();
System.out.println(rc);
int colc=driver.findElementsByXPath("//table/tbody/tr[1]/td").size();

for(int i=1;i<=rc;i++){
	
	String xx= driver.findElementByXPath("//table/tbody/tr["+i+"]/td[2]").getText();
if(xx.equals(comparison)){
				String comparison1=driver.findElementByXPath("//table/tbody/tr["+i+"]/td[3]/a").getText();
				if (comparison1.equals("Harley Quinn")){
				System.out.println("Employee Name verified and is positive");	
				}
				break;
	}
}
driver.switchTo().parentFrame();
driver.findElementByXPath("//ul/li[3]/a[contains(text(),'Logout')]").click();
String verifyinglogout=driver.getTitle();
if(verifyinglogout.equals("OrangeHRM - New Level of HR Management"))
	System.out.println("home page dispalyed after logout");
else
	System.out.println("failed to display home page after logout");
	
	
}
}
