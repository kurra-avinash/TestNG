package Mar10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNgclass {
	WebDriver driver;
	@BeforeTest
	public void setup() 
	{
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://orangehrm.qedgetech.com/");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();
		Reporter.log("Running in beforetest",true);
		
		
	}
	@Test
	public void admin()
	{
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
		Reporter.log("Executing admin test",true);
	}
	@Test
	public void pim()
	{
		driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
		Reporter.log("Executing pim test",true);
	}
	@Test
	public void leave()
	{
		driver.findElement(By.xpath("//b[normalize-space()='Leave']")).click();
		Reporter.log("Executing leave test",true);
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		Reporter.log("Running in After Test",true);
	}
	
	}

	


