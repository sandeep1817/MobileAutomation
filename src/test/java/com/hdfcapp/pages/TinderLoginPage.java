package com.hdfcapp.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TinderLoginPage {
	
	private AppiumDriver<MobileElement> driver;
	
	public TinderLoginPage(){
		
	}
	public TinderLoginPage(AppiumDriver driver){
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath = "//android.widget.Button[@text='LOG IN WITH PHONE NUMBER']")
	public MobileElement logInWithPhnNoBtn;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone Number']")
	public MobileElement phoneNoTxtBox;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
	public MobileElement continueBtn;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.tinder:id/oneTimePasswordInputView']")
	public MobileElement OTPTextBox;
	
	@AndroidFindBy(accessibility = "View Profile")
	public MobileElement viewProfileIcon;
	
	
	public void logInIntoTinder(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logInWithPhnNoBtn)).click();;
		wait.until(ExpectedConditions.visibilityOf(phoneNoTxtBox)).sendKeys("9502260695");
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
		wait.until(ExpectedConditions.visibilityOf(OTPTextBox)).sendKeys("9502260695");
	}
	public void waitTillElement(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(viewProfileIcon));
	}
}
