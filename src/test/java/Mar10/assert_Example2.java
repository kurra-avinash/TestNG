package Mar10;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class assert_Example2 {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		
	}
	@Test
	public void test1() {
		String expected = "joogle";
		String actual = driver.getTitle();
		try {
			Assert.assertTrue(actual.equalsIgnoreCase(expected),"Title is not matching");
			
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void test2() {
		String expected = "Google";
		String actual = driver.getTitle();
		try {
			Assert.assertFalse(actual.equalsIgnoreCase(expected), "title is matching");
			
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@AfterMethod
	public void teardown2()
	{
		driver.quit();
		
	}
	
	

}