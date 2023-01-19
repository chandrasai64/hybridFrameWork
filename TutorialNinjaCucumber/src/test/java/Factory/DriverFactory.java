package Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utils.CommonUtils;

public class DriverFactory {

	static WebDriver driver = null;

	public  WebDriver IntializeBrowser(String browsername) {
		
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equals("forefox"))

		{
			driver = new FirefoxDriver();
		} else if (browsername.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browsername.equals("safari"))

		{
			driver = new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGELOAD_WAIT_TIME));
		return driver;
		}
	public  WebDriver getDriver()
	{
		return driver;
	}
}
