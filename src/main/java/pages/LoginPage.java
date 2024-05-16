package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	
	private WebDriver driver;
	ElementUtils elementUtils;
	
	//By Locators
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement loginButton;
	
    @FindBy(xpath="//input[@id='user-name']")
    private WebElement username;
    
    @FindBy(xpath="//input[@id='password']")
    private WebElement password;
    
    @FindBy(xpath="//span[@class='title' and text()='Products']")
    private WebElement productTitle;
    
	
	//Contractor of the page class	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	//pageactions	
	public String getLoginpageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterusername(String loginusername)
	{
		elementUtils.typeTextintoElement(username, loginusername, 10);
	}
	
	public void enterPassword(String loginpassword)
	{
		elementUtils.typeTextintoElement(password, loginpassword, 10);
	}
	
	public void clickLoginButton()
	{
		elementUtils.clickOnElement(loginButton, 10);
	}
	
	public String getProductTitle()
	{
		return productTitle.getText();
	}
	
	public void doLogin(String uid, String pwd)
	{
		elementUtils.typeTextintoElement(username, uid, 10);
		elementUtils.typeTextintoElement(password, pwd, 10);
		elementUtils.clickOnElement(loginButton, 10);
	}

}
