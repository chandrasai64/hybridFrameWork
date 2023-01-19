package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;
import Utils.ElementsUtils;

public class AccountSuccessPage {
	
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public AccountSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils=new ElementsUtils(driver);

	}
	
	@FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
	private WebElement AccountSuccessMessage;
	
	public String retriveAccountsuccessMessage()
	{
		return elementsUtils.getTextfromElement(AccountSuccessMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return AccountSuccessMessage.getText();
	}

}
