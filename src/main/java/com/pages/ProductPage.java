package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	WebDriver driver;

	//By Locators
	private By AddToCart = By.xpath("//a[@class='shopping_cart_link']");
	private By productname = By.xpath("//div[text()='Sauce Labs Backpack']//following::div[1]/following::div[1]/button");
	private By cartbutton = By.xpath("//span[@class='shopping_cart_badge']");
	private By productincardpage = By.xpath("//div[@class='cart_item']//div[text()='Sauce Labs Backpack']");
	private By checkOutButton = By.xpath("//button[@id='checkout']");
	private By checkoutinformation = By.xpath("//span[text()='Checkout: Your Information']");
	private By firstName = By.xpath("//input[@id='first-name']");
	private By lastName = By.xpath("//input[@id='last-name']");
	private By zipCode = By.xpath("//input[@id='postal-code']");
	private By continueButton = By.xpath("//input[@id='continue']");
	private By checkoutOverview = By.xpath("//span[text()='Checkout: Overview']");
	private By finishButton = By.xpath("//button[@id='finish']");
	private By orderConfirmationMessage = By.xpath("//div[@id='checkout_complete_container']/h2[text()='Thank you for your order!']");
	
	
	//Contractor of the page class
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//pageaction
	
	public void addProduct()
	{
		driver.findElement(productname).click();
	}
	
	public void clickCartButton()
	{
		driver.findElement(AddToCart).click();
	}
	
	public boolean productInCartPage()
	{
		return driver.findElement(productincardpage).isDisplayed();
	}
	
	public void clickCheckOutButton()
	{
		driver.findElement(checkOutButton).click();
	}
	
	public boolean checkoutInformationPage()
	{
		return driver.findElement(checkoutinformation).isDisplayed();
	}
	
	public void enterFirstName(String firtname)
	{
		driver.findElement(firstName).sendKeys(firtname);
	}
	
	public void enterLastName(String lastname)
	{
		driver.findElement(lastName).sendKeys(lastname);
	}
	
	public void enterZipcode(String zipcode)
	{
		driver.findElement(zipCode).sendKeys(zipcode);
	}
	
	public boolean checkoutoverview()
	{
		return driver.findElement(checkoutOverview).isDisplayed();
	}
	
	public void clickContinueButton()
	{
		driver.findElement(continueButton).click();
	}
	
	public void clickFinishButton()
	{
		driver.findElement(finishButton).click();
	}
	
	public boolean confirmationAlertMessage()
	{
		return driver.findElement(orderConfirmationMessage).isDisplayed();
	}
}
