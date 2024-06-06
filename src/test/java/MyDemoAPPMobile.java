import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;

public class MyDemoAPPMobile {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AppiumDriver driver = null;
		UiAutomator2Options options = new UiAutomator2Options()
				.setPlatformName("Android")
				.setPlatformVersion("14.0")
				.setAutomationName("UiAutomator2")
				.setDeviceName("emulator-5554")
				.setAppPackage("com.saucelabs.mydemoapp.rn")
				.setAppActivity(".MainActivity")
				.setNoReset(true);
		
				
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")).click();
				driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='menu item log in']")).click();
				driver.findElement(AppiumBy.accessibilityId("Username input field")).clear();
				driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
				driver.findElement(AppiumBy.accessibilityId("Password input field")).clear();
				driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
				driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Login button']")).click();

	}

}
