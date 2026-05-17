package Mar12;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Register_test {
	WebDriver driver;
	Properties conpro;
	@Test
	public void startTest() throws Throwable
	{
		conpro = new Properties();
	conpro.load(new FileInputStream("C:\\Users\\AVINASH\\eclipse-workspace\\TestNg_Project\\OR.properties"));
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(conpro.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	driver.findElement(By.xpath(conpro.getProperty("ObjReg"))).click();
	driver.findElement(By.xpath(conpro.getProperty("Objname"))).sendKeys(conpro.getProperty("EnterName"));
	driver.findElement(By.xpath(conpro.getProperty("Objcontact"))).sendKeys(conpro.getProperty("Entercontact"));
	driver.findElement(By.xpath(conpro.getProperty("ObjEmail"))).sendKeys(conpro.getProperty("EnterEmail"));
	driver.findElement(By.xpath(conpro.getProperty("Objpass"))).sendKeys(conpro.getProperty("Enterpass"));
	Thread.sleep(3000);
	new Select(driver.findElement(By.xpath(conpro.getProperty("Objgender")))).selectByValue(conpro.getProperty("EnterGender"));;
	driver.findElement(By.xpath(conpro.getProperty("Objdob"))).sendKeys(conpro.getProperty("Enterdob"));
	Thread.sleep(3000);
	driver.findElement(By.xpath(conpro.getProperty("Objcheckbox"))).click();;
	driver.findElement(By.xpath(conpro.getProperty("Objregister"))).click();
	Thread.sleep(3000);
	driver.quit();
	
	}
	
	

}
