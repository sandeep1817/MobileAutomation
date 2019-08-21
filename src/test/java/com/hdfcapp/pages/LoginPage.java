package com.hdfcapp.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage {
	
	private AppiumDriver<MobileElement> driver;
    public LoginPage() {
    	
    }
    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

	@AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
	public MobileElement allowBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='No']")
	public MobileElement noBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Customer ID / User ID']")
	public MobileElement custIdBtn;
	
	/*@AndroidFindBy(xpath = "//*[@bounds='[540,339][1047,459]']")
	public MobileElement custIdBtn;
	*/
	@AndroidFindBy(id = "fldLoginUserId")
	public MobileElement custIDTxtBox;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
	public MobileElement continueBtn;
	
	@AndroidFindBy(id = "upass")
	public MobileElement passwordTxtBox;
	
	@AndroidFindBy(id = "chkLogin")
	public MobileElement checkBox;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
	public MobileElement loginBtn;
	
	
	public void login(String user,String password) throws InterruptedException{
		allowBtn.click();
		noBtn.click();
		Set<String> handles = driver.getContextHandles();
		System.out.println("Numbere of contexts: "+handles.size());
		for(String context:handles){
			if(!(context.equalsIgnoreCase("NATIVE_APP"))){
				driver.context(context);
				break;
			}
			else{
				System.out.println("Context is: "+context);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.elementToBeClickable(custIdBtn));
		if(custIdBtn.isEnabled()){
			custIdBtn.click();
		}
		else{
			driver.findElement(By.xpath("//android.view.View[@id='contentData']//android.widget.ListView/android.view.View[2]")).click();
			System.out.println("Inside else");
		}
		custIDTxtBox.sendKeys(user);
		continueBtn.click();
		passwordTxtBox.sendKeys(password);
		checkBox.click();
		loginBtn.click();
	}
	public void verifyThatHomePageDisplayed() {
		System.out.println("Inside then");
	}
	}
