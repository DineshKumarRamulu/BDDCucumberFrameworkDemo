package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauseLabHomePage {
	
	private WebDriver driver;
	
	//@FindBy(xpath="//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")
	//private WebElement openmenu;
	
	private By openmenu = By.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView");
	
	public SauseLabHomePage(WebDriver driver)
	{
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void openMenuClick()
	{
		driver.findElement(openmenu).click();
	}
	

}
