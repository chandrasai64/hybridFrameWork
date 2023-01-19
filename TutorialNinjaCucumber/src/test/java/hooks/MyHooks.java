
package hooks;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks 
{

	WebDriver driver;
	private ConfigReader configReader;
	private DriverFactory driverFactory;
	@Before
	public void SetUp()
	{
		//4 configReader=new ConfigReader();
		//4 Properties prop = configReader.intializeProperties();
		Properties prop=new ConfigReader().intializeProperties();
		 driverFactory=new DriverFactory();
		 driver=driverFactory.IntializeBrowser(prop.getProperty("browser"));
		//4 driver=DriverFactory.getDriver();
		 driver.get(prop.getProperty("Url"));

	}
	@After
	public void tearDown(Scenario scenario)
	{
		String scenarioName = scenario.getName().replace(" ", "_");
		if(scenario.isFailed())
		{
			byte[] screeenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screeenShot, "image/png", scenarioName);
		}
		driver.quit();

	}
}
