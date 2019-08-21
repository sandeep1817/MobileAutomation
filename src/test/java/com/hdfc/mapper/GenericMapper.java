package com.hdfc.mapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.hdfcapp.pages.HomePage;
import com.hdfcapp.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GenericMapper {
	public AppiumDriver driver;
	
	@BeforeClass
	public void setUpCapabilities() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","e906a3c");
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("appPackage", "com.snapwork.hdfcbank");
		capabilities.setCapability("appActivity", "com.snapwork.hdfcbank.HDFCBank");
		System.setProperty("webdriver.chrome.driver", "C:\\Workspaces\\chromedriver_win32\\chromedriver.exe");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void setDriver(AppiumDriver<MobileElement> driver){
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
	}
	 
	@Given("^hdfc bank application is launched$")
	public void launchTheHDFCApp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//ChromeOptions options = new ChromeOptions();
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("deviceName","emulator-5554");
		capabilities.setCapability("appPackage", "com.snapwork.hdfcbank");
		capabilities.setCapability("appActivity", "com.snapwork.hdfcbank.HDFCBank");
		//capabilities.setCapability("noReset", true);
		//capabilities.setCapability("fullReset", false);
		System.setProperty("webdriver.chrome.driver", "C:\\Workspaces\\chromedriver_win32_2.33\\chromedriver.exe");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/*@Given("^username \"([^\"]*)\" and password \"([^\"]*)\" entered$")*/
	@When("username \"([^\"]*)\" and password \"([^\"]*)\" entered")
	public void enterCredentials(String user,String password) throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(user, password);
	}
	@Then("^home page of the application should display$")
	public void validateHomePageDisplayed(){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyThatHomePageDisplayed();
	}
	@When("^user clicked on Account summary$")
	public void clickOnAccountSummary(){
		HomePage homePage = new HomePage(driver);
		homePage.verifyTheBalanace();
	}
	@Then("^validate the balance in the account$")
	public void validateBalanceInAccount(){
		System.out.println("Verified");
	}
}
