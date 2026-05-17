package Mar12;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Using_DataProvider {
	WebDriver driver;
	@Parameters ({"Browser"})
	  @BeforeTest
	  public void setUp(String brw) {
		switch (brw) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			break;
		case  "firefox":
			driver = new FirefoxDriver();
		driver.manage().window().maximize();
		break;
		case "MicrosoftEdge":
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		break;
			
		default:
			System.out.println("Browser value are not matching");
			break;}
		}
  @Test(dataProvider = "dp")
  public void admin_login(String user, String pass) throws Throwable {
	  driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.name("txtUsername")).sendKeys(user);
	  driver.findElement(By.name("txtPassword")).sendKeys(pass);
	  driver.findElement(By.name("Submit")).click();
	  Thread.sleep(3000);
	  String expected = "dashboard";
	  String actual = driver.getCurrentUrl();
	  if (actual.contains(expected)) {
		  Reporter.log("valid credentials"+expected+"   "+actual,true);
	}
	  else {
		  Reporter.log("Invalid credentials"+expected+"   "+actual,true);
	}
  }

  @DataProvider
  public Object[][] dp() {
    Object login[][] = {
    		{"Admin","Qedge123!@#"},
    		{"Ranga","Qedge123!@#"},
    		{"Admin","harry"},
    		{"","Qedge123!@#"},
    		{"Admin",""}
    };
    return login;
    }

  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
 

}
