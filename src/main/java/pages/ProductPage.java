package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class ProductPage {
	
	WebDriver driver;
    ElementUtils elementUtils;
    
	//By Locators
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement AddToCart;
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']//following::div[1]/following::div[1]/button")
	private WebElement productname;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement cartbutton;
	
	@FindBy(xpath="//div[@class='cart_item']//div[text()='Sauce Labs Backpack']")
	private WebElement productincardpage;
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkOutButton;
	
	@FindBy(xpath="//span[text()='Checkout: Your Information']")
	private WebElement checkoutinformation;
	
	@FindBy(xpath="//input[@id='first-name']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	private WebElement zipCode;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//span[text()='Checkout: Overview']")
	private WebElement checkoutOverview;
	
	@FindBy(xpath="//button[@id='finish']")
	private WebElement finishButton;
	
	@FindBy(xpath="//div[@id='checkout_complete_container']/h2[text()='Thank you for your order!']")
	private WebElement orderConfirmationMessage;
	
	
	//Contractor of the page class
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	//pageactions	
	public void addProduct()
	{
		elementUtils.clickOnElement(productname, 10);
	}
	
	public void clickCartButton()
	{
		elementUtils.clickOnElement(AddToCart, 10);
	}
	
	public boolean productInCartPage()
	{
		return productincardpage.isDisplayed();
	}
	
	public void clickCheckOutButton()
	{
		elementUtils.clickOnElement(checkOutButton, 10);
	}
	
	public boolean checkoutInformationPage()
	{
		return checkoutinformation.isDisplayed();
	}
	
	public void enterFirstName(String fn)
	{
		elementUtils.typeTextintoElement(firstName,fn, 10);
	}
	
	public void enterLastName(String ln)
	{
		elementUtils.typeTextintoElement(lastName,ln, 10);
	}
	
	public void enterZipcode(String zip)
	{
		elementUtils.typeTextintoElement(zipCode,zip, 10);
	}
	
	public boolean checkoutoverview()
	{
		return checkoutOverview.isDisplayed();
	}
	
	public void clickContinueButton()
	{
		elementUtils.clickOnElement(continueButton, 10);
	}
	
	public void clickFinishButton()
	{
		elementUtils.clickOnElement(finishButton, 10);
	}
	
	public boolean confirmationAlertMessage()
	{
		return orderConfirmationMessage.isDisplayed();
	}
}
