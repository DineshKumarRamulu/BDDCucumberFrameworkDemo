package com.qa.factory;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static ThreadLocal<WebDriver> tl_driver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tl_driver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tl_driver.set(new FirefoxDriver());
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tl_driver.set(new EdgeDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser value "+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tl_driver.get();
	}
}
