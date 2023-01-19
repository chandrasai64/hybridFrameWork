package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Pages.HomePage;
import Pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {

	WebDriver driver;
	HomePage homePage;
	private SearchPage searchPage;
	private DriverFactory driverFactory;

	@Given("user opens application")
	public void user_opens_application() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
	}

	@When("user enter valid product {string} into search box field")
	public void user_enter_valid_product_into_search_box_field(String ValidProductText) {

		homePage = new HomePage(driver);
		homePage.enterProductNameInSearchBox(ValidProductText);
		// 3 driver.findElement(By.name("search")).sendKeys(ValidProductText);
	}

	@When("user click on search button")
	public void user_click_on_search_button() {
		homePage = new HomePage(driver);
		searchPage = homePage.clickSearchButton();
		// 3
		// driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();

	}

	@Then("user should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		// 4 SearchPage searchPage=new SearchPage(driver);
		Assert.assertTrue("valis product is not displayed", searchPage.displaystausofValidProduct());
		// Assert.assertTrue(driver.findElement(By.linkText("HP
		// LP3065")).isDisplayed());
		//Assert.assertEquals("Chandra", "chandra");
	}

	@When("user enter invalid product {string} into search box field")
	public void user_enter_invalid_product_into_search_box_field(String InvalidproductText) {
		homePage = new HomePage(driver);
		homePage.enterProductNameInSearchBox(InvalidproductText);

		// 3 driver.findElement(By.name("search")).sendKeys(InvalidproductText);
	}

	@Then("user should get a message aboout no product matching")
	public void user_should_get_a_message_aboout_no_product_matching() {
		// 4 SearchPage searchPage=new SearchPage(driver);
		Assert.assertEquals(searchPage.displayStausofInvalidProduct(),
				"There is no product that matches the search criteria.");
		// 3 Assert.assertEquals("There is no product that matches the search
		// criteria.",driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText());

	}

	@When("user dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {

	}
}
