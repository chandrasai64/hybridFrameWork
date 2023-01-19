package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;
import Utils.ElementsUtils;

public class LoginPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils=new ElementsUtils(driver);

	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-password")
	private WebElement PasswordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	public void enterEmailIntoEmailfield(String emailText)
	{
		//emailField.sendKeys(emailText);
		elementsUtils.typeTextintoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public void enterPasswordintoPasswordField(String passwordText)
	{
		PasswordField.sendKeys(passwordText);
		elementsUtils.typeTextintoElement(PasswordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	public AccountPage clickonLoginButton()
	{
		//loginButton.click();
		elementsUtils.clickonElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	public String retriveWarningMessage()
	{
		return elementsUtils.getTextfromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return warningMessage.getText();
	}
	
	

}
