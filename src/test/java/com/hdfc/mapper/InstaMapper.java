package com.hdfc.mapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.hdfcapp.pages.TinderLoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class InstaMapper {

	public AppiumDriver driver;

	@Given("^instagram application is launched$")
	public void launchInstagram() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "e906a3c");
		capabilities.setCapability("appPackage", "com.tinder");
		capabilities.setCapability("appActivity", "com.tinder.activities.MainActivity");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Continue as Sandeep Reddy']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@When("^swipe action is performed$")
	public void swipeTheScreen() throws InterruptedException{
		Dimension size = driver.manage().window().getSize();
		System.out.println("Height of the screen is: "+size.height +" Width of the screen is: "+size.width);
		int startx = (int) (size.width*0.20);
		int endx = (int) (size.width*0.80);
		System.out.println("Starrting point is: "+startx);
		System.out.println("ending point is: "+endx);
		int starty = (int) (size.height/2);
		TinderLoginPage tlp = new TinderLoginPage(driver);
		TouchAction act = new TouchAction(driver);
		PointOption p = new PointOption();
		for(int i=0;i<=20;i++){
			tlp.waitTillElement();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			act.press(p.withCoordinates(startx, starty)).moveTo(p.withCoordinates(endx, starty)).release().perform();
		}
	}
	@Then("^verify that messages tab is opened$")
	public void validateMessagesScreenDispalyed(){
		System.out.println("Inside then");
	}
}
