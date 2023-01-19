package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;
import Utils.ElementsUtils;

public class RegisterPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils=new ElementsUtils(driver);

	}
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement TelenumField;
	
	@FindBy(id = "input-password")
	private WebElement PasswordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continuebtn;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsletterOption;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement emailwarningMessage;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarning;
	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarning;
	
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telePhonenumWarning;
	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarning;
	
	public void enterFirstname(String firstnameText)
	{
		elementsUtils.typeTextintoElement(firstNameField, firstnameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//firstNameField.sendKeys(firstnameText);
	}
	public void enterLastname(String lastnameText)
	{
		elementsUtils.typeTextintoElement(lastNameField, lastnameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//lastNameField.sendKeys(lastnameText);
	}
	public void enterEmail(String emilText)
	{
		elementsUtils.typeTextintoElement(emailField, emilText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//emailField.sendKeys(emilText);
	}
	public void entertelenum(String TelenumText)
	{
		elementsUtils.typeTextintoElement(TelenumField, TelenumText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//TelenumField.sendKeys(TelenumText);
	}
	public void enterPassword(String passwordText)
	{
		elementsUtils.typeTextintoElement(PasswordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//PasswordField.sendKeys(passwordText);
	}
	public void enterConfirmPassword(String confirmpasswordText)
	{
		elementsUtils.typeTextintoElement(confirmPasswordField, confirmpasswordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//confirmPasswordField.sendKeys(confirmpasswordText);
	}
	public void selectPrivacypolicyOption()
	{
		elementsUtils.clickonElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//privacyPolicyOption.click();
	}
	public AccountSuccessPage clickOnContinueButton()
	{
		elementsUtils.clickonElement(continuebtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//continuebtn.click();
		return new AccountSuccessPage(driver);
	}
	public void selectNewsLetterOption()
	{
		elementsUtils.clickonElement(newsletterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//newsletterOption.click();
	}
	public String retriveEmailwarningMessage()
	{
		return elementsUtils.getTextfromElement(emailwarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return emailwarningMessage.getText();
	}
	
	
	public String retrivePrivacyPolicyWarningMessage()
	{
		return elementsUtils.getTextfromElement(privacyPolicyWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//return privacyPolicyWarning.getText();
	}
	
	public String retriveFirstNameWarningMessage()
	{
		return elementsUtils.getTextfromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//return firstNameWarning.getText();
	}
	
	public String retrivelastNameWarningMessage()
	{
		return elementsUtils.getTextfromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//return lastNameWarning.getText();
	}
	
	public String retriveemailWarningMessage()
	{
		return elementsUtils.getTextfromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//return emailWarning.getText();
	}
	
	public String retriveTeleNumWarningMessage()
	{
		return elementsUtils.getTextfromElement(telePhonenumWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//return telePhonenumWarning.getText();
	}
	
	public String retrivePasswordWarningMessage()
	{
		return elementsUtils.getTextfromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//return passwordWarning.getText();
	}
	
	
	
	
	
	
}
