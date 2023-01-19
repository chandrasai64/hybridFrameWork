package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;
import Utils.ElementsUtils;

public class AccountPage {
	
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils=new ElementsUtils(driver);

	}
	@FindBy(linkText = "Edit your account information")
	private WebElement EdityourAccountinformation;
	
	public boolean displayStatusofEdityourAccountinformation()
	{
		return elementsUtils.displaystatusOfElement(EdityourAccountinformation, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return EdityourAccountinformation.isDisplayed();
	}
}
