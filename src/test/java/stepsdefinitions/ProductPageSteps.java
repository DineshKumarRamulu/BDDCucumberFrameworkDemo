package stepsdefinitions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pages.LoginPage;
import com.pages.ProductPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps {
	
	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	ProductPage productpage = new ProductPage(DriverFactory.getDriver());
	
	String expectedProductTitle = "Products";
	
	@Given("user is on product page")
	public void user_is_on_product_page() {
		String actualProductTitle = loginpage.getProductTitle();
		System.out.println(actualProductTitle);
		Assert.assertEquals(actualProductTitle, expectedProductTitle);
	}

	@When("user add the {string} to the cart")
	public void user_add_the_to_the_cart(String productname) {
		//productpage.addProduct();
		WebElement product = DriverFactory.getDriver().findElement(By.xpath("//div[text()='"+productname+"']//following::div[1]/following::div[1]/button"));
		product.click();
		
	}
	
	@When("user clicks the cart button")
	public void user_clicks_the_cart_button() {
		productpage.clickCartButton();
	}

	@Then("product should be available in the cart page")
	public void product_should_be_available_in_the_cart_page() throws InterruptedException {
	    boolean flag = productpage.productInCartPage();
	    Assert.assertTrue(flag);
	    System.out.println(flag);
	    //Thread.sleep(10000);
	}
	
	@Then("{string} should be available in the cart page")
	public void should_be_available_in_the_cart_page(String productname) {
		WebElement product = DriverFactory.getDriver().findElement(By.xpath("//div[text()='"+productname+"']//following::div[1]/following::div[1]/button"));
		boolean flag = product.isDisplayed();
		Assert.assertTrue(flag);
	    System.out.println(flag);
	}

	@When("user click on the checkout button")
	public void user_click_on_the_checkout_button() throws InterruptedException {
	    productpage.clickCheckOutButton();
	    //Thread.sleep(10000);
	}

	@Then("user should see the Checkout:Your information page")
	public void user_should_see_the_checkout_your_information_page() {
	    boolean checkoutInformation = productpage.checkoutInformationPage();
	    Assert.assertTrue(checkoutInformation);
	}

	@Then("user provide the firstname {string}")
	public void user_provide_the_firstname(String firstname) {
	    productpage.enterFirstName(firstname);
	}
	
	@Then("user provide the lastname {string}")
	public void user_provide_the_lastname(String lastname) {
		productpage.enterLastName(lastname);
	}
	
	@Then("user provide the zipcode {string}")
	public void user_provide_the_zipcode(String zipcode) {
		productpage.enterZipcode(zipcode);
	}

	
	@Then("user should see the checkout:overview page")
	public void user_should_see_the_checkout_overview_page() {
	    boolean flag = productpage.checkoutoverview();
	    Assert.assertTrue(flag);
	}

	@When("user click the continue button")
	public void user_click_the_continue_button() {
		productpage.clickContinueButton();
	}

	@When("user click the Finish button")
	public void user_click_the_finish_button() {
		productpage.clickFinishButton();
	}

	@Then("user should get the alert message as Thank you for your order!")
	public void user_should_get_the_alert_message_as_thank_you_for_your_order() throws InterruptedException {
	    boolean flag = productpage.confirmationAlertMessage();
	    Assert.assertTrue(flag);
	    Thread.sleep(10000);
	}

}
