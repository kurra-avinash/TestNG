package Mar10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Second_TestNgclass {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.qedgetech.com/calculator.html");
		Reporter.log("Running in before method",true);	
	}
	@Test(priority = 2)
	public void addition() 
	{
		driver.findElement(By.name("display")).sendKeys("45634");
		driver.findElement(By.xpath("//tbody/tr[2]/td[5]/input[1]")).click();
		driver.findElement(By.name("display")).sendKeys("7685");
		driver.findElement(By.xpath("//tbody/tr[5]/td[4]/input[1]")).click();
		
		String Add =driver.findElement(By.name("display")).getAttribute("value");
		Reporter.log(Add,true);
	}
	@Test(description = "validate substraction", enabled = true,priority = 0,invocationCount = 5)
	public void substraction() 
	{
		driver.findElement(By.name("display")).sendKeys("45634");
		driver.findElement(By.xpath("//tbody/tr[3]/td[5]/input[1]")).click();
		driver.findElement(By.name("display")).sendKeys("7685");
		driver.findElement(By.xpath("//tbody/tr[5]/td[4]/input[1]")).click();
		
		String Sub =driver.findElement(By.name("display")).getAttribute("value");
		Reporter.log(Sub,true);
	}
	@Test(enabled = false)
	public void division() 
	{
		driver.findElement(By.name("display")).sendKeys("45634");
		driver.findElement(By.xpath("//tbody/tr[5]/td[5]/input[1]")).click();
		driver.findElement(By.name("display")).sendKeys("7685");
		driver.findElement(By.xpath("//tbody/tr[5]/td[4]/input[1]")).click();
		
		String Div =driver.findElement(By.name("display")).getAttribute("value");
		Reporter.log(Div,true);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		Reporter.log("Running in After Test",true);
	}
	

}
