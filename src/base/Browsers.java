package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Browsers 
{
	public WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser) throws Exception
	{
		try {
			if(browser.equalsIgnoreCase("Firefox"))
			{
				driver=new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("Chrome")) 
			{
				System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", "");
				driver=new InternetExplorerDriver();
			}
			else{
				throw new Exception("Browser is not correct");
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
		
		driver.get("http://se3-rnd.stg.adam.com/content.aspx?productId=45");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


	}
	
	@AfterTest
	public void clsBrowser()
	{
		driver.quit();
		
	}

}
