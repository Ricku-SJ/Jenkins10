import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenEx {

	WebDriver driver;

	@BeforeClass
	public void open() throws IOException
	{
		Reporter.log("Open",true);
		//Properties p=new Properties();
		System.out.println(System.getProperty("browser"));
		if(System.getProperty("browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(System.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	}
	@Test
	public void project()
	{
		Reporter.log("Project",true);
	}
	@BeforeMethod
	public void login()
	{
		System.out.println(System.getProperty("url"));
			driver.get(System.getProperty("url"));
	}

		@AfterMethod
		public void logout()
		{
			Reporter.log("Logout",true);
		}
		@AfterClass
		public void close()
		{
			Reporter.log("Close",true);
		}
	}

