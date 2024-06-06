package stepsdefinitions;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauseLabHomePage;
import utils.ConfigReader;

public class SauseLabAppSteps {
	
	DriverFactory driverFactory;
	
	ConfigReader configreader;
	Properties prop;
	WebDriver driver;
	SauseLabHomePage sauseLabHomePage = new SauseLabHomePage(DriverFactory.getDriver()) ;
	
	@Given("launch the SauseLab Application")
	public void launch_the_sause_lab_application() throws MalformedURLException {
		
		configreader = new ConfigReader();
		prop = configreader.init_properties();
		
		String value = prop.getProperty("browser");
		driverFactory = new DriverFactory();
	    driver = driverFactory.init_driver(value);
	}

	@Given("user click the Open menu")
	public void user_click_the_open_menu() {
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")).click();
		//sauseLabHomePage.openMenuClick();
	}

	@Given("user click the login link")
	public void user_click_the_login_link() {
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='menu item log in']")).click();
	}

	@When("user enters the userid {string}")
	public void user_enters_the_userid(String username) {
		driver.findElement(AppiumBy.accessibilityId("Username input field")).clear();
		driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys(username);
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String password) {
		driver.findElement(AppiumBy.accessibilityId("Password input field")).clear();
		driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys(password);
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Login button']")).click();
	}

	@Then("user should be taken to the products page")
	public void user_should_be_taken_to_the_products_page() {
	    
	    boolean flag = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Products']")).isDisplayed();
	    assertEquals(flag, true);
	  
	}
	
	@Given("select the product {string}")
	public void select_the_product(String productName) {
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='store item text' and @text='"+productName+"']")).click();
	}

	@Given("click add to cart button")
	public void click_add_to_cart_button() {
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Add To Cart button']")).click();
	}

	@When("click the cart badge")
	public void click_the_cart_badge() {
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='cart badge']")).click();
	}

	@Then("the selected product {string} should be added in My Cart page")
	public void the_selected_product_should_be_added_in_my_cart_page(String productName) {
	    
	    boolean flag = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+productName+"']")).isDisplayed();
	    assertEquals(flag, true);
	    
	  
	}

}
