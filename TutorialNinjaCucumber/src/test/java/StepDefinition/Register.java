package StepDefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Pages.AccountSuccessPage;
import Pages.HomePage;
import Pages.RegisterPage;
import Utils.CommonUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register 
{
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;

@Given("User has navigate to Register Account page")
public void user_has_navigate_to_register_account_page() {
	 driverFactory=new DriverFactory();
	driver=driverFactory.getDriver();
	HomePage homePage=new HomePage(driver);
	homePage.clickOnMyaccount();
	registerPage=homePage.selectRegisterOption();
	//3 driver.findElement(By.xpath("//span[text()='My Account']")).click();
	//3 driver.findElement(By.linkText("Register")).click();
   

}

@When("User enter the details below field")
public void user_enter_the_details_below_field(DataTable dataTable) {
	
	Map<String, String> datamap = dataTable.asMap(String.class,String.class);
   
	 //4 registerPage=new RegisterPage(driver);
	registerPage.enterFirstname(datamap.get("firstName"));
	registerPage.enterLastname(datamap.get("lastName"));
	 commonUtils=new CommonUtils();
	registerPage.enterEmail(commonUtils.getEmailWithTimestamp());

	registerPage.entertelenum(datamap.get("telephone"));
	registerPage.enterPassword(datamap.get("password"));
	registerPage.enterConfirmPassword(datamap.get("password"));

//3	driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("firstName"));
//   driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("lastName"));
//   driver.findElement(By.id("input-email")).sendKeys(getEmailwithTimeStamp());
//   driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("telephone"));
//   driver.findElement(By.id("input-password")).sendKeys(datamap.get("password"));
//   driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("password"));

}

@When("User enter the details below field with duplicate email")
public void user_enter_the_details_below_field_with_duplicate_email(DataTable dataTable) {
	
	Map<String, String> datamap = dataTable.asMap(String.class,String.class);
	//4 registerPage=new RegisterPage(driver);
	registerPage.enterFirstname(datamap.get("firstName"));
	registerPage.enterLastname(datamap.get("lastName"));
	registerPage.enterEmail(datamap.get("email"));

	registerPage.entertelenum(datamap.get("telephone"));
	registerPage.enterPassword(datamap.get("password"));
	registerPage.enterConfirmPassword(datamap.get("password"));
//   driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("firstName"));
//   driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("lastName"));
//   driver.findElement(By.id("input-email")).sendKeys(datamap.get("email"));
//   driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("telephone"));
//   driver.findElement(By.id("input-password")).sendKeys(datamap.get("password"));
//   driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("password"));

}

@When("user select privacy policy")
public void user_select_privacy_policy() {
	
	registerPage.selectPrivacypolicyOption();
  //3  driver.findElement(By.name("agree")).click();
}

@When("user click on continue button")
public void user_click_on_continue_button() {
	
	accountSuccessPage=registerPage.clickOnContinueButton();
    //3 driver.findElement(By.xpath("//input[@type='submit']")).click();
}

@Then("user account should get created successfully")
public void user_account_should_get_created_successfully() {
	
//	4  AccountSuccessPage accountSuccessPage=new AccountSuccessPage(driver);
	
	
	Assert.assertEquals("Congratulations! Your new account has been successfully created!",accountSuccessPage.retriveAccountsuccessMessage());
  
	//3 Assert.assertEquals("Congratulations! Your new account has been successfully created!",driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p")).getText());
    }

@When("user select news letter option")
public void user_select_news_letter_option() {
	registerPage.selectNewsLetterOption();
	//3 driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
    }

@Then("user should get proper warning about duplicate email")
public void user_should_get_proper_warning_about_duplicate_email() {
	Assert.assertTrue(registerPage.retriveEmailwarningMessage().contains("Warning: E-Mail Address is already registered!"));
	//3 Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
   }

@When("user dont enter any details into fields")
public void user_dont_enter_any_details_into_fields() {
	
	//intentionally kept Blank
	registerPage.enterFirstname("");
	registerPage.enterLastname("");
	registerPage.enterEmail("");

	registerPage.entertelenum("");
	registerPage.enterPassword("");
	registerPage.enterConfirmPassword("");
    }

@When("click on continue button")
public void click_on_continue_button() {
	//4 registerPage=new RegisterPage(driver);
	registerPage.clickOnContinueButton();
    //3 driver.findElement(By.xpath("//input[@type='submit']")).click();

}

@Then("user should get proper warning message for every mandatory fields")
public void user_should_get_proper_warning_message_for_every_mandatory_fields() {
	
	Assert.assertEquals("Warning: You must agree to the Privacy Policy!",registerPage.retrivePrivacyPolicyWarningMessage());
	Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.retriveFirstNameWarningMessage());
	Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.retrivelastNameWarningMessage());
	Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.retriveemailWarningMessage());
	Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.retriveTeleNumWarningMessage());
	Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.retrivePasswordWarningMessage());

	
	
//	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
//	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText().contains("First Name must be between 1 and 32 characters!"));
//	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText().contains("Last Name must be between 1 and 32 characters!"));
//	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText().contains("E-Mail Address does not appear to be valid!"));
//	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText().contains("Telephone must be between 3 and 32 characters!"));
//	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText().contains("Password must be between 4 and 20 characters!"));

}

}
