package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;
import Utils.ElementsUtils;

public class HomePage {
	 
	WebDriver driver;
	private ElementsUtils elementsUtils;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils=new ElementsUtils(driver);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropmenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBoxField;
	
	@FindBy(xpath = "//button[contains(@class,'btn-default')]" )
	private WebElement searchButton;
	
	public void clickOnMyaccount()
	{
		//myAccountDropmenu.click();
	     elementsUtils.clickonElement(myAccountDropmenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public LoginPage selectLoginOption()
	{
		//loginOption.click();
		elementsUtils.clickonElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	public RegisterPage selectRegisterOption()
	{
		//registerOption.click();
		elementsUtils.clickonElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	public void enterProductNameInSearchBox(String ProductName)
	{
		//searchBoxField.sendKeys(ProductName);
		elementsUtils.typeTextintoElement(searchBoxField, ProductName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public SearchPage clickSearchButton()
	{
		//searchButton.click();
		elementsUtils.clickonElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		return new SearchPage(driver);
	}
	

}
