package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.CommonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;

	@Given("User has navigate to login page")
	public void user_has_navigate_to_login_page() {

		 driverFactory=new DriverFactory();
		driver = driverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyaccount();
		
		loginPage=homePage.selectLoginOption();
		// 3driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// 3driver.findElement(By.linkText("Login")).click();
	}

	@When("^User has enter valid email address (.+) into email field$")
	public void user_has_enter_valid_email_address_into_email_field(String EmailText) {
		//4 loginPage = new LoginPage(driver);
		loginPage.enterEmailIntoEmailfield(EmailText);
		// 3driver.findElement(By.id("input-email")).sendKeys(EmailText);
	}

	@And("^user has enter valid password  (.+) into password field$")
	public void user_has_enter_valid_password_into_password_field(String PasswordText) {

		loginPage.enterPasswordintoPasswordField(PasswordText);
		// 3driver.findElement(By.id("input-password")).sendKeys(PasswordText);
	}



	@And("user click on login button")
	public void user_click_on_login_button() {
		accountPage=loginPage.clickonLoginButton();
		// 3driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("user should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		// 4 AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusofEdityourAccountinformation());
		// 3Assert.assertTrue(driver.findElement(By.linkText("Edit your account
		// information")).isDisplayed());
	}

	@When("User has enter Invalid email address  into email field")
	public void user_has_enter_invalid_email_address_into_email_field() {
		
		 commonUtils=new CommonUtils();
		
		//4 loginPage = new LoginPage(driver);
		loginPage.enterEmailIntoEmailfield(commonUtils.getEmailWithTimestamp());
		// 3 driver.findElement(By.id("input-email")).sendKeys(getEmailwithTimeStamp());
	}

	@When("user has enter Invalid password  {string} into password field")
	public void user_has_enter_invalid_password_into_password_field(String InvalidPasswordText) {

		loginPage.enterPasswordintoPasswordField(InvalidPasswordText);
		// 3 driver.findElement(By.id("input-password")).sendKeys(InvalidPasswordText);

	}

	@Then("user should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {

		Assert.assertTrue(
				loginPage.retriveWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
		// 3
		// Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning:
		// No match for E-Mail Address and/or Password."));
	}

	@When("user dont enter any email address into email field")
	public void user_dont_enter_any_email_address_into_email_field() {
		//4 loginPage = new LoginPage(driver);
		loginPage.enterEmailIntoEmailfield("");
		// 3 driver.findElement(By.id("input-email")).sendKeys("");
	}

	@When("user dont enter any password into password field")
	public void user_dont_enter_any_password_into_password_field() {
		loginPage.enterPasswordintoPasswordField("");
		// 3 driver.findElement(By.id("input-password")).sendKeys("");
	}

}