package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//By Locators
	private By username = By.xpath("//input[@id='user-name']");
	private By password = By.xpath("//input[@id='password']");	
	private By loginButton = By.xpath("//input[@id='login-button']");
	private By productTitle = By.xpath("//span[@class='title' and text()='Products']");
	
	//Contractor of the page class
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//pageaction
	
	public String getLoginpageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterusername(String loginusername)
	{
		driver.findElement(username).sendKeys(loginusername);
	}
	
	public void enterPassword(String loginpassword)
	{
		driver.findElement(password).sendKeys(loginpassword);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	public String getProductTitle()
	{
		return driver.findElement(productTitle).getText();
	}
	
	public void doLogin(String uid, String pwd)
	{
		driver.findElement(username).sendKeys(uid);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
	}

}
