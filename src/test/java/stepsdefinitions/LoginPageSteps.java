package stepsdefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginPageSteps {


LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
String expectedProductTitle = "Products";
private ConfigReader configreader;
Properties prop;
String title;

@Given("user is on login page")
public void user_is_on_login_page() throws InterruptedException {
	configreader = new ConfigReader();
	prop = configreader.init_properties();
	String url = prop.getProperty("url");
	
    DriverFactory.getDriver().get(url);
    Thread.sleep(5000);
    
}

@When("user gets title of the page")
public void user_gets_title_of_the_page() {
   title = loginpage.getLoginpageTitle();
   
}

@Then("page title should be {string}")
public void page_title_should_be(String ExpectedTitle) {
	Assert.assertEquals(title, ExpectedTitle);
}

@When("user enters userid {string}")
public void user_enters_userid(String username) {
   loginpage.enterusername(username);
}

@When("user enters password {string}")
public void user_enters_password(String password) {
   loginpage.enterPassword(password);
}

@When("user clicks on login button")
public void user_clicks_on_login_button() {
    loginpage.clickLoginButton();
}

@Then("user should be landed to the products page")
public void user_should_be_landed_to_the_products_page() {
    
	String actualProductTitle = loginpage.getProductTitle();
	System.out.println(actualProductTitle);
	Assert.assertEquals(actualProductTitle, expectedProductTitle);
}

@Given("User has already login into the application")
public void user_has_already_login_into_the_application(DataTable datatable) {
	configreader = new ConfigReader();
	prop = configreader.init_properties();
	String url = prop.getProperty("url");
    List<Map<String,String>> credList = datatable.asMaps(String.class, String.class);
    String username = credList.get(0).get("username");
    String password = credList.get(0).get("password");
    DriverFactory.getDriver().get(url);
    loginpage.doLogin(username, password);
    }
}




