package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementsUtils;

public class SearchPage 
{
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils=new ElementsUtils(driver);

	}
	@FindBy(linkText = "HP LP3065")
	private WebElement displaystausofProduct;
	
	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	private WebElement displaystausofInvalidProduct;
	
	public boolean displaystausofValidProduct()
	{
		return elementsUtils.displaystatusOfElement(displaystausofProduct, 15);
		//return displaystausofProduct.isDisplayed();
	}
	public String displayStausofInvalidProduct()
	{
		return elementsUtils.getTextfromElement(displaystausofInvalidProduct, 15);
		//return displaystausofInvalidProduct.getText();
	}

}
