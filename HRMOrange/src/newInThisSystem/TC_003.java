package newInThisSystem;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class TC_003 {

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

		 //click on employee to be edited 
		 WebElement shouldbeedited=driver.findElementByXPath("//tbody/tr/td[3]/a");
shouldbeedited.click();
// capture employee id
String empId=driver.findElementByXPath("//input[@name='txtEmployeeId']").getAttribute("value");
// click on edit
driver.findElementByXPath("//input[@id='btnEditPers']").click();
//clear the first & last name and enter the new ones
driver.findElementByXPath("//input[@id='txtEmpFirstName'] ").clear();
driver.findElementByXPath("//input[@id='txtEmpFirstName'] ").sendKeys("Na");
driver.findElementByXPath("//input[@id='txtEmpLastName']").clear();
driver.findElementByXPath("//input[@id='txtEmpLastName']").sendKeys("Ve");
// click on save
driver.findElementByClassName("savebutton").click();
driver.switchTo().parentFrame();
A.moveToElement(driver.findElementByXPath("//span[contains(text(),'PIM')]")).perform();
A.click(driver.findElementByXPath("//a/span[contains(text(),'Employee List')]")).perform();
driver.switchTo().frame("rightMenu");
String EmpIddup=driver.findElementByXPath("//table/tbody/tr/td[2]").getText();

if(EmpIddup.equals(empId))
{
/*	driver.switchTo().frame("rightMenu");*/
String abcd=driver.findElementByXPath("//table/tbody/tr/td[3]/a").getText();

if(abcd.equals("Na Ve"))
		{		
	System.out.println("edit successfull");
		}
	else {
		System.out.println("edit failed");
		}
	
	
}
}
}
