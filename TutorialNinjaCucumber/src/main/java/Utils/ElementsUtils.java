package Utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtils {
	WebDriver driver;
	public ElementsUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickonElement(WebElement element,long durationinSeconds)
	{
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
		WebElement webelement=wait.until(ExpectedConditions.elementToBeClickable(element));
	   //webelement=waitForElement(element, durationinSeconds);
		webelement.click();
	}
	public void typeTextintoElement(WebElement element,String texttobeTyped,long durationinSeconds)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
		WebElement webelement=wait.until(ExpectedConditions.elementToBeClickable(element));
		webelement.click();
		webelement.clear();
		webelement.sendKeys(texttobeTyped);

	}
	public WebElement waitForElement(WebElement element,long durationinSeconds)
	{
		WebElement webelement = null;
		try {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
			 webelement= wait.until(ExpectedConditions.elementToBeClickable(element));
			
			
		} catch (Throwable e) {
		 e.printStackTrace();
		}
		return webelement;
		
	}
	public void selectOptionDropdown(WebElement element,String dropDownOption,long durationinSeconds)
	{
		WebElement webelement=waitForElement(element, durationinSeconds);
		Select select=new Select(webelement);
		select.selectByVisibleText(dropDownOption);

	}
	public void accetAlert(long durationinSeconds)
	{
		Alert alert=waitforAlert(durationinSeconds);
		alert.accept();
	}
	public void dismissAlert(long durationinSeconds)
	{
		Alert alert=waitforAlert(durationinSeconds);
		alert.dismiss();
	}
    public Alert waitforAlert(long durationinSeconds)
    {
    	Alert alert=null;
    	try {
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
    	 alert=wait.until(ExpectedConditions.alertIsPresent());
    	}catch (Throwable e) {
    		e.printStackTrace();
		}
    	return alert;
    }
    public void mouseOverandClick(WebElement element,long durationinSeconds)
    {
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
    	WebElement webelement = wait.until(ExpectedConditions.visibilityOf(element));
    	//WebElement webelement=waitforVisibilityOfElement(webelement, durationinSeconds);
    	Actions actions=new Actions(driver);
    	actions.moveToElement(webelement).click().build().perform();
    }
    public WebElement waitforVisibilityOfElement(WebElement element,long durationinSeconds)
    {
    	WebElement webelement = null;
    	try {
        	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
        	 webelement = wait.until(ExpectedConditions.visibilityOf(element));
        	}catch (Throwable e) {
        		e.printStackTrace();
    		}
    	return webelement;
    }
    public void javascriptClick(WebElement element,long durationinSeconds)
    {
    	WebElement webelement = waitforVisibilityOfElement(element, durationinSeconds);
    	
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", webelement);
    }
    public void javascriptType(WebElement element,String texttobeTyped,long durationinSeconds)
    {
    	WebElement webelement = waitforVisibilityOfElement(element, durationinSeconds);
    	
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].value='"+texttobeTyped+"'", webelement);
    	
    }
    public String getTextfromElement(WebElement element,long durationinSeconds)
    {
    	WebElement webelement = waitForElement(element, durationinSeconds);
    	return webelement.getText();
    }
    
    public boolean displaystatusOfElement(WebElement element,long durationinSeconds)
    {
    	try {
    	WebElement webelement=waitforVisibilityOfElement(element, durationinSeconds);
    	return webelement.isDisplayed();
    	}catch (Throwable e) {
    		return false;

    	}
    }
}
