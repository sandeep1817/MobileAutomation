package com.hdfc.mapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.hdfcapp.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GenericMapper {
	public AndroidDriver driver;
	
	//LoginPage loginPage;
	
	@Given("^hdfc bank application is launched$")
	public void launchTheHDFCApp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","e906a3c");
		capabilities.setCapability("appPackage", "com.snapwork.hdfcbank");
		capabilities.setCapability("appActivity", "com.snapwork.hdfcbank.HDFCBank");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("^username \"([^\"]*)\" and password \"([^\"]*)\" entered$")
	public void enterCredentials(String user,String password){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(user, password);
	}
	@Then("^home page of the application should display$")
	public void validateHomePageDisplayed(){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyThatHomePageDisplayed();
	}
}
